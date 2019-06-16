package com.zengyao.NIO;

import java.nio.ByteBuffer;

public class TestBuffer {
	public static void main(String[] args) throws Exception {
		
		ByteBuffer buffer = ByteBuffer.allocate(8);
		
		byte[] temp = new byte[]{3,2,1};
		
		// 写入数据之前 ： java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
		// pos - 游标位置， lim - 限制数量， cap - 最大容量
		System.out.println("写入数据之前 ： " + buffer);
		
		// 写入字节数组到缓存
		buffer.put(temp);
		
		// 写入数据之后 ： java.nio.HeapByteBuffer[pos=3 lim=8 cap=8]
		// 游标为3， 限制为8， 容量为8
		System.out.println("写入数据之后 ： " + buffer);
		
		// 重置游标 ， lim = pos ;  pos = 0;
		buffer.flip();
		
		// 重置游标之后 ： java.nio.HeapByteBuffer[pos=0 lim=3 cap=8]
		// 游标为0， 限制为3， cap为8
		System.out.println("重置游标之后 ： " + buffer);

		System.out.println("remaining: "+buffer.remaining());
		
		// 清空Buffer， pos = 0; lim = cap;
		// buffer.clear();
		
		// get() -> 获取当前游标指向的位置的数据。
		// System.out.println(buffer.get());
		
		/*for(int i = 0; i < buffer.remaining(); i++){
			// get(int index) -> 获取指定位置的数据。
			int data = buffer.get(i);
			System.out.println(i + " - " + data);
		}*/
	}
}
