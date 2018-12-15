package cn.coderstyle.demo.aop;

/**
 * 用户测试aop的业务类
 * 
 * @author champion
 *
 */
public class MathCalculator {
	
	/**
	 * 使用aop的目的：记录参数，记录结果 
	 * @return
	 */
	
	public int div(int i,int j) {
		System.out.println("运行div方法.....");
		return i/j;
	}
}
