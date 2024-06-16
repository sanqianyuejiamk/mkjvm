

class mengka {

	def qingcai
	
	static main(args) {

		println sum(11,1,3)

		println sum(11,4)

		println sum(15)
	}

	
	/**
	 *  不带参数的方法测试
	 * 
	 * @return
	 */
	def baicai(){
		println sum(11,1,3)
	}
	
	
	/**
	 *  带参数的方法测试
	 * 
	 * @param aa
	 * @param bb
	 * @param cc
	 * @return
	 */
	def baicai(def aa,def bb,def cc){
		println "$aa-$bb-$cc"
	}

	def qingcai(){
		println "qingcai = "+qingcai
	}
	
	static int sum(int... kk){
		def count=0

		for(i in kk){
			count+=i
		}

		return count
	}
}