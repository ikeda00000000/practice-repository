package javaPractice1;

/*
 * 北ソフト工房6.メソッドの練習問題
 */
public class JavaMethodPractice {

	public static void main(String[] args) {
		System.out.println(square(3));
		System.out.println(average(4,10));
		
		// 3つの整数のうち最も大きい数字を返す
		int x = 5;
		int y = 10;
		int z = 8;
		int compareResult = largerInt(largerInt(x, y),z);
		System.out.println(compareResult);
		
		drawTriangle(3);
		

	}
	
	/*
	 * 整数の2乗を計算する
	 * @param number この整数を2乗する
	 * @return 2乗した結果を返す
	 */
	public static int square(int number) {
		return number*number;
	}
	
	/*
	 * 2つの整数の平均を計算する
	 * @param number1,number2 この整数の平均を出す
	 * @return 2つの数の平均
	 */
	public static int average(int number1, int number2) {
		return (number1 + number2) / 2; 
	}
	
	/*
	 * 2つの整数の大きいほうを返す
	 * @param number1,number2 比較する整数
	 * @return 大きいほうの整数
	 */
	public static int largerInt(int number1, int number2) {
		return number1 > number2 ? number1 : number2;
	}	
	
	/*
	 * 整数を引数として適当な文字で三角形を表示する
	 * @param number 三角形のサイズ
	 */
	public static void drawTriangle(int size) {
		// number=3なら、まず1つ＄、次に2つ＄、そして3つ＄を表示して処理終了
		for (int i = 1; i < size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("$");
			}
		} 
	}
	
	/*
	 * サイズを示す数値と表示する文字を引数として三角形を表示する
	 * @param number 三角形のサイズ
	 * @param char 三角形を作る文字
	 * @return 文字列で作られた三角形
	 */

}
