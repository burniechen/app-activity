Tasks and the back stack
===

# singleTask & FLAG_ACTIVITY_BROUGHT_TO_FRONT
* If, when starting the activity, there is already a task running that starts with this activity, then instead of starting a new instance the current task is brought to the front. 
* The existing instance will receive a call to Activity.onNewIntent() with the new Intent that is being started, and with the Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT flag set. 
* This is a superset of the singleTop mode, where if there is already an instance of the activity being started at the top of the stack, it will receive the Intent as described there (without the FLAG_ACTIVITY_BROUGHT_TO_FRONT flag set).
* The system creates the activity at the root of a new task or locates the activity on an existing task with the same affinity. 
* If an instance of the activity already exists, the system routes the intent to the existing instance through a call to its onNewIntent() method, rather than creating a new instance. 
* Meanwhile all of the other activities on top of it are destroyed.

## Example
**Before**
In task 1 \
Activity 1->2->3->4
```kotlin!
// MainActivity4
val intent = Intent(context, MainActivity2::class.java).apply {
    flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
    putExtra("toEnd", true)
}
startActivity(intent)
```
**After**
In task 1 \
Activity 1->2->5
```kotlin!
// MainActivity2
override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)

    val toEnd = intent?.getBooleanExtra("toEnd", false) ?: false
    Log.d(tag, "has extra: ${intent?.hasExtra("toEnd")}, value: $toEnd")

    if (toEnd) {
        val mIntent = Intent(applicationContext, MainActivity5::class.java)
        startActivity(mIntent)
    }
}
```
