# java incorrectly synchronized demo

java 的编程有很多时候需要在多线程中共享变量，很多时候我们只知道这个例子是正确的。
但是不知道
- 错误的例子为什么会错
- 如何复现这个错误的例子


在jsr-133中描述了需要注意的三个点：
- Visibility
- Ordering
- Atomicity   

当我们共享变量不满足上面的性质会容易导致我们看到一些很奇怪的现象




|名称|内容|影响|
|---|---|---|
|Loop May Never End|对象的可见性|由于可见性导致程序不会停止|
|doubule check demo| 双检锁对象部分初始化|对象部分初始化|
|IncrementTestDemo|volatile 写不是原子的|原子性不满足|


---


happen before

- Each action in a thread happens-before every subsequent action in that thread.
- An unlock on a monitor happens-before every subsequent lock on that monitor.
- A write to a volatile field happens-before every subsequent read of that volatile.
- A call to start() on a thread happens-before any actions in the started thread.
- All actions in a thread happen-before any other thread successfully returns from a join() on
that thread.
- If an action a happens-before an action b, and b happens before an action c, then a happens-
before c.


相关阅读  
- https://vlambda.com/wz_7izhR5mopBc.html
