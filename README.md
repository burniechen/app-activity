Tasks and the back stack
===

# singleInstance
* Only allow one instance of this activity to ever be running. 
* This activity gets a unique task with only itself running in it; if it is ever launched again with the same Intent, then that task will be brought forward and its Activity.onNewIntent() method called. 
* If this activity tries to start a new activity, that new activity will be launched in a separate task.
* The activity is always the single and only member of its task. Any activities started by this one open in a separate task.

## Example
**Begin** \
task#1 : Activity 1 

**First** \
task#1 : Activity 1 \
task#2 : Activity 2 
```kotlin!
// MainActivity1
val intent = Intent(applicationContext, MainActivity2::class.java)
startActivity(intent)
```

**Second** \
task#1 : Activity 1->3->4 \
task#2 : Activity 2 
```kotlin!
// MainActivity2
val intent = Intent(applicationContext, MainActivity3::class.java)
startActivity(intent)
// MainActivity3
val intent = Intent(applicationContext, MainActivity4::class.java)
startActivity(intent)
```

**Third** \
task#1 : Activity 1->3->4 \
task#2 : Activity 2 
```kotlin!
// MainActivity4
 val intent = Intent(applicationContext, MainActivity2::class.java).apply {
    putExtra("toEnd", true)
}
startActivity(intent)
```
**Final** \
task#1 : Activity 1->3->4->5 \
task#2 : Activity 2 
```kotlin!
// MainActivity2
 override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)

    val toEnd = intent?.getBooleanExtra("toEnd", false) ?: false
    if (toEnd) {
        val mIntent = Intent(applicationContext, MainActivity5::class.java)
        startActivity(mIntent)
    }
}
```
