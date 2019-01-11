#Java多线程实现的方式有四种
* 1.继承Thread类，重写run方法
* 2.实现Runnable接口，重写run方法，实现Runnable接口的实现类的实例对象作为Thread构造函数的target
* 3.通过Callable和FutureTask创建线程
* 4.通过线程池创建线程
    > public static ExecutorService newFixedThreadPool(int nThreads)
      创建固定数目线程的线程池。
      
    > public static ExecutorService newCachedThreadPool()
      创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
    
    > public static ExecutorService newSingleThreadExecutor()
      创建一个单线程化的Executor。
      
    > public static ScheduledExecutorService newScheduledThreadPool(intcorePoolSize)
      创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
           
    > newSingleThreadScheduledExcutor：创建一个单例线程池，定期或延时执行任务。
           
    > newWorkStealingPool:创建持有足够线程的线程池来支持给定的并行级别，并通过使用多个队列，减少竞争，它需要穿一个并行级别的参数，如果不传，则被设定为默认的CPU数量。
           
    > ForkJoinPool：支持大任务分解成小任务的线程池，这是Java8新增线程池，通常配合ForkJoinTask接口的子类RecursiveAction或RecursiveTask使用
    
    ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。


   [参考1](https://blog.csdn.net/u011480603/article/details/75332435/)
   
   [参考:线程池](https://blog.csdn.net/a369414641/article/details/48342253)