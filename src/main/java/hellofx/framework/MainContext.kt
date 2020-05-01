package hellofx.framework

class MainContext {
    fun <T> getObj(key: String): T {
        if (!objRepo.containsKey(key))
            throw RuntimeException("No key: " + key)
        return objRepo[key] as T
    }

    private val router = Router()
    val objRepo = hashMapOf<String, Any>()
    fun notify(eventName: String, obj: Any) {
        router.call(eventName, obj)
    }

    fun listen(eventName: String, action: () -> Unit) {
        router.register(eventName) {
            action()
        }
    }

    fun <T> listen(eventName: String, action: (value: T) -> Unit) {
        router.register(eventName) {
            val tValue = it as T
            action(tValue)
        }

    }
}