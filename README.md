# Agenda - an Android Calendar App
----
Note. *Time will be selected from dropdown bar, so there should not be a formatting problem any longer.*

Instructions:
1. Register or login:
    * to register need to enter user name, password, and email.
    * to login need to enter user name and password.
    * up to now our calendar can only support 1 user to use
2. Now menu have options that can be choose.
3. Enter the option want to operate.
4. Option1: create
    can create events, alarts, tags,memos, and series.
    by type in options, can create by directions that system prints out.
    for creating events or alert,  type in time must be in the format that given by the direction, else, cannot create
    for creating tag and memo, if no event exist, then must create event first, then create tag or memo; if there are
    events exist user will see a list of event with a unique number, user can put event number and separete them by
    comma to  give those events memo or tag.
    //creating series caution.
5.Option2: view
    * can view events by time, view memo, view by alert, view by time, and view all events that the user have.
6. Option3: search
    * this option is maily for search memo and tag
    * user can input some words to see if there exits any memo contains those words
    * user can input a tag name to see if this tag exits
7. Option4: delete event
    * user can delete event by input event name
8. Logout
    *  user can logout account and sign in again. When user logout, all information are written into their files.
    *  event information are read at the moment user login.
9. Exit
    * system will terminate
    * all information are stored at the moment of exiting

Our plan:
    * we plan to put a change function to our system, user can change password,
        change event name, time, change memo content or tag name, add new event to an existing memo or tag,
        delete event from a memo or tag...
    * a part of the change function is already been written in main package, change class
    * we also plan to put a "today" function, which can help user to have a
        quick view of all today's events

Note:
* When input options, please use the correct format as the system described; otherwise, some exceptions may appear;
  We will try to fix this in phase2.
* Formats like "11-22-2020 11:00" is not acceptable because we only have 12 months
