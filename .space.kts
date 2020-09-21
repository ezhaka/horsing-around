
/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, refer to https://www.jetbrains.com/help/space/automation.html
*/

job("Example shell script") {
    container("ubuntu") {
        shellScript {
            content = """
                echo Hello
                echo World!
            """
        }
    }
}
