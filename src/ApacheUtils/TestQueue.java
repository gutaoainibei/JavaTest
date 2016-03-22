package ApacheUtils;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 
 * 描述：测试apache的工具队列
 *     CircularFifoQueue循环队列
 * @author gt
 * @created 2016年3月22日 下午11:46:04
 * @since
 */
public class TestQueue {
   public static void main(String[] args) {
	CircularFifoQueue<Integer> circularFifoQueue = new CircularFifoQueue<Integer>();
	circularFifoQueue.add(1);
	circularFifoQueue.add(2);
	circularFifoQueue.add(3);
	for (Integer integer : circularFifoQueue) {
		System.out.println(integer);
	}
	Queue<Integer> readOnlyqueue = UnmodifiableQueue.unmodifiableQueue(circularFifoQueue);
    //这里将他改为只读队列    
	// readOnlyqueue.add(12);
	
	Predicate<Integer> predicate = NotNullPredicate.notNullPredicate();
	//断言队列
	Queue<Integer> predicateQueue = PredicatedQueue.predicatedQueue(circularFifoQueue, predicate);
	predicateQueue.add(null);
   }
}
