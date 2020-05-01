package hellofx.framework

class MainContext {
    fun <T> getObj(key: String): T {
        if (!objRepo.containsKey(key))
            throw RuntimeException("No key: " + key)
        return objRepo[key] as T
    }

    val router = Router()
    val objRepo = hashMapOf<String, Any>()
    fun notify(eventName: String, obj: Any) {
        router.call(eventName, obj)
    }
}