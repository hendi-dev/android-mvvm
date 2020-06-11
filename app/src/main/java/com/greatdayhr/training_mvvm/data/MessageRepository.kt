package com.greatdayhr.training_mvvm.data

class MessageRepository() {
    fun getMessage(callback: ((String) -> Unit)?) {

        // Run in different thread
        Thread(Runnable {
            Thread.sleep(1500)
            callback?.let {
                it("Random message ${Math.random()}")
            }
        }).start()
    }
}
