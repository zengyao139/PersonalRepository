ualSize=length<blockSize?(length):blockSize;
		for(int i=0;i<size;i++) {
			pos=i*blockSize;
			if(i==size-1) {
				actualSize=length;
			}else {
				actualSize=blockSize;
				length-=actualSize;
			}
			splitToSubFile(i,pos,actualSize);
		}
	}
	private void splitToSubFile(int i, int pos, int actualSize) throws IOException {
	//	System.out.println(this.fromFile.length()+"i: "+i+"  actualSize: "+actualSize);
		RandomAccessFile raf=new RandomAccessFile(this.fromFile,"r");
		RandomAccessFile raf2=new RandomAccessFile(new File(this.destPath.get(i)), "rw");
		//随机位置读，，定位到具体位置
		raf.seek(pos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush, 0, len);
				actualSize-=len;
			}else {
				raf2.write(flush, 0,actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	
	public static void main(String[] args)throws Exception {
		SplitUtils sp=new SplitUtils("src/com/zengyao/split/SplitUt