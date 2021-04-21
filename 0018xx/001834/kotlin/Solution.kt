import java.util.*

class Solution {
  fun getOrder(tasks: Array<IntArray>): IntArray {
    var taskAry:Array<Task?> = Array<Task?>(tasks.size){i->null}
    for(i in tasks.indices){
      taskAry[i] = Task(i,tasks[i][0],tasks[i][1])
    }
    taskAry.sortWith(StarttimeOrderSort())

    val retAry:IntArray = IntArray(tasks.size)
    var retAryDone:Int = 0
    val waitingTaskSet:TreeSet<Task> = TreeSet<Task>()
    var time:Int = 0
    var taskAryDone:Int = 0
    while(retAryDone<tasks.size){
      // if no waiting task, push time to first future task
      if((waitingTaskSet.size<=0)&&(time<taskAry[taskAryDone]!!.startTime)){
        time = taskAry[taskAryDone]!!.startTime
      }
      // fill all task on time from taskAry to waitingTaskSet
      while((taskAryDone<taskAry.size) && (time>=taskAry[taskAryDone]!!.startTime)){
        waitingTaskSet.add(taskAry[taskAryDone]!!)
        taskAryDone+=1
      }
      // fill retAry from waitingTaskSet to retAry
      val task:Task = waitingTaskSet.first()
      waitingTaskSet.remove(task)
      retAry[retAryDone] = task.order
      time+=task.timeLen
      retAryDone+=1
    }

    return retAry
  }
}

data class Task(val order:Int, val startTime:Int, val timeLen:Int):Comparable<Task> {
  override fun compareTo(other: Task): Int{
    var diff: Int = 0
    diff = this.timeLen - other.timeLen
    if(diff!=0)return diff
    diff = this.order - other.order
    if(diff!=0)return diff
    return 0
  }
}

class StarttimeOrderSort:Comparator<Task?>{
  override fun compare(a:Task?, b:Task?):Int{
    if((a==null)&&(b==null))return 0
    if(a==null)return -1
    if(b==null)return 1
    var diff: Int = 0
    diff = a.startTime - b.startTime
    if(diff!=0)return diff
    diff = a.order - b.order
    if(diff!=0)return diff
    return 0
  }
}

