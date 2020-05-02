package hellofx.framework

class Router
{
    private val eventRepo = hashMapOf<String, ArrayList<(Any)->Unit>>()
    fun register(eventName: String, consumer: (Any)->Unit) {
        if (!eventRepo.containsKey(eventName)){
            eventRepo[eventName] = arrayListOf()
        }
        val eventList = eventRepo[eventName]!!
        eventList.add(consumer)
    }

    fun call(eventName: String, obj: Any){
        if (!eventRepo.containsKey(eventName)){
            eventRepo[eventName] = arrayListOf()
        }
        val eventList = eventRepo[eventName]!!
        for(event in eventList){
            event(obj)
        }
    }
}
