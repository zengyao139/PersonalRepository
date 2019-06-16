package com.zengyao.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Server implements Runnable {

	private Selector selector;
	private ByteBuffer readerBuffer =ByteBuffer.allocate(1024);
	private ByteBuffer writerBuffer =ByteBuffer.allocate(1024);	
	
	public static void main(String[] args) {
		new Thread(new Server(9999)).start();
	}
	public Server(int port) {
		init(port);
	}
	private void init(int port) {
		try {
			System.out.println("server starting at port "+port +" ........");
			//������·������
			this.selector=Selector.open();
			//��������ͨ��
			ServerSocketChannel serverChannel=ServerSocketChannel.open();
			//������
			serverChannel.configureBlocking(false);
			//�󶨶˿�
			serverChannel.bind(new InetSocketAddress(port));
			//ע�ᵱǰ����ͨ��
			serverChannel.register(this.selector,SelectionKey.OP_ACCEPT);
			
			System.out.println("server started______");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	@Override
	public void run() {
		while(true) {
			try {
				//��������������һ��ͨ����ѡ��ʱ���˷����ŷ���	
				this.selector.select();
				Iterator<SelectionKey> keys=this.selector.selectedKeys().iterator();
				while(keys.hasNext()) {
					SelectionKey key=keys.next();
					keys.remove();
					if(key.isValid()) {
						try {
							if(key.isAcceptable())
								accept(key);
						} catch (Exception e) {
							key.cancel();
						}
						try {
							if(key.isReadable())
								read(key);
						} catch (Exception e) {
							key.cancel();
						}
						try {
							if(key.isWritable())
								write(key);
						} catch (Exception e) {
							key.cancel();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void accept(SelectionKey key) {
		try {
			ServerSocketChannel serverChannel=(ServerSocketChannel)key.channel();
			SocketChannel channel=serverChannel.accept();
			channel.configureBlocking(false);
			channel.register(this.selector,SelectionKey.OP_READ);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void read(SelectionKey key) {
		try {
			this.readerBuffer.clear();
			SocketChannel channel=(SocketChannel)key.channel();
			int readLength=channel.read(readerBuffer);
			if(readLength==-1) {
				key.channel().close();
				key.cancel();
				return ;
			}
			this.readerBuffer.flip();
			byte[] datas=new byte[readerBuffer.remaining()];
			readerBuffer.get(datas);
			System.out.println("from: "+ channel.getRemoteAddress()+ "client �� "+ new String(datas,"utf-8"));
			channel.register(this.selector,SelectionKey.OP_WRITE);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				key.channel().close();
				key.cancel();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public void write(SelectionKey key) {
		this.writerBuffer.clear();
		SocketChannel channel=(SocketChannel)key.channel();
		Scanner  reader=new Scanner(System.in);		
		try {
			System.out.println("put message for send to client >");
			String message=reader.nextLine();
			writerBuffer.put(message.getBytes());
			writerBuffer.flip();
			channel.write(writerBuffer);
			
			channel.register(this.selector,SelectionKey.OP_READ);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
