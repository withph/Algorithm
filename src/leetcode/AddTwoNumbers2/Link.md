# **总结**

自己用的比较暴力，先将ListNode转换为int，然后相加，最后再转回为ListNode。

中间自己遇到的问题：int溢出，导致测试用例没有过全，后来换成BigInteger来解决，才跑完所有用例。

BigInteger的常用语法：
    + BigInteger a=BigInteger.valueOf(1);  //初始化
    + BigInteger b=BigInteger('1');        //字符串初始化
    + a.add(b);                            //加
    + a.subtract(b);                       //减
    + a.multiply(b);                       //乘
    + a.divide(b);                         //除
    + a.mod(b);                            //取模
    + a.remainder(b);                      //求余
    
官方给的题解思考：
    变量跟踪进位，包含最低有效位的表头开始模拟逐位相加的过程，求和运算最后可能出现额外的进位。