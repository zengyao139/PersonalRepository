package com.zengyao.NIO;

import java.nio.ByteBuffer;

public class TestBuffer {
	public static void main(String[] args) throws Exception {
		
		ByteBuffer buffer = ByteBuffer.allocate(8);
		
		byte[] temp = new byte[]{3,2,1};
		
		// д������֮ǰ �� java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
		// pos - �α�λ�ã� lim - ���������� cap - �������
		System.out.println("д������֮ǰ �� " + buffer);
		
		// д���ֽ����鵽����
		buffer.put(temp);
		
		// д������֮�� �� java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
		// �α�Ϊ3�� ����Ϊ8�� ����Ϊ8
		System.out.println("д������֮�� �� " + buffer);
		
		// �����α� �� lim = pos ;  pos = 0;
		buffer.flip();
		
		// �����α�֮�� �� java.nio.HeapByteBuffer[pos=0 lim=3 cap=8]
		// �α�Ϊ0�� ����Ϊ3�� capΪ8
		System.out.println("�����α�֮�� �� " + buffer);

		System.out.println("remaining: "+buffer.remaining());
		
		// ���Buffer�� pos = 0; lim = cap;
		// buffer.clear();
		
		// get() -> ��ȡ��ǰ�α�ָ���λ�õ����ݡ�
		// System.out.println(buffer.get());
		
		/*for(int i = 0; i < buffer.remaining(); i++){
			// get(int index) -> ��ȡָ��λ�õ����ݡ�
			int data = buffer.get(i);
			System.out.println(i + " - " + data);
		}*/
	}
}
