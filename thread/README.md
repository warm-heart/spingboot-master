

当synchronized修饰 static方法时  锁是基于类级别的（object的两个对象p1 p2都受影响，当线程操作p1时 ，
另外线程操作p2会受到影响）



当synchronized修饰普通方法时 锁是基于对象级别的 （ object的两个对象p1 p2 互不影响，
当不同线程操作同一对象p1时 则会有锁现象，当两个线程分别操作 p1 p2时无影响）


static修饰的变量存储在方法区，所有的线程都可以访问，当用final修饰表示变量不可被修改，
故 private static final 修饰一些常量（共有的）