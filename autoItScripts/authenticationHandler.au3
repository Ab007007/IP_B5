WinWaitActive("Authentication Required")
Sleep(2000)
send("dummyUser123")
Sleep(2000)
Send("{TAB}")
send("dummyPassword")
send("{ENTER}")


