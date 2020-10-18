<h1>Fundamental Project – CRUD Application</h1> 

 

<h2>Project Overview</h2>

The project brief had tasked me to develop a CRUD (Create, Read, Update, Delete) application using the technologies we had been taught and the knowledge we possessed. This would be a fully functional program, although basic in functionality, this would encapsulate five weeks' worth of content into one application. Overall, this project will cover: 

<ul>
  <li>Project Management</li>
  <li>Databases</li>
  <li>Java SE</li>
  <li>Spring Boot</li>
  <li>Front-End Development</li>
  <li>Automated Testing</li>
</ul>
 

<h2>Requirements:</h2>

This project required the following, all of which are also documented within this README: 

<ul>
  <li>A Jira board with full expansion on user stories, use cases and tasks needed to complete the project.</li>
  <li>Clear Documentation from a design phase describing the architecture you will use for your project. </li>
  <li>A detailed Risk Assessment created at the beginning of your project. </li>
  <li>A relational database used to store data persistently for the project. </li>
  <li>A functional application created in the OOP language, following best practices and design principles, that you have covered during training, this application needs to meet the requirements set on your Kanban Board </li>
  <li>The application must have a functioning front-end website and integrated API. </li>
  <li>Fully designed test suites for the application you are creating, as well as automated tests for validation of the application. </li>
  <li>You must meet an acceptable level of test coverage in your backend and provide consistent reports and evidence that you have done so. </li>
  <li>Code fully integrated into a Version Control System </li>
</ul>
 

<h2>My Solution</h2>

For the completion of this project, I was required to assess my abilities being introduced to coding for the first time and the deadline provided. The conclusion I had come to was to produce a basic To Do List application, as this could be branched off in the future to more complex projects, yet the To Do List would have the potential to fulfil all requirements whilst also test my learning progress and abilities. 

The simple To Do List application would allow for the following functionality: 

<ul>
  <li>User is able to create a task and add to the To Do list</li>
  <li>User is able to edit the task within the list </li>
  <li>User is able to select the task to be completed and placed into the Completed list </li>
  <li>User is able to delete the task once it has been completed </li>
</ul>

Each task will be saved to the in memory H2 database, which would then be updated with each feature selected on the task. Attempts had been made to connect and host the database on a GCP SQL instance, however this was unsuccessful. 

 

<h2>Project Management</h2>

Being an individual project, this hadn't left much room for full scrum practise to be implemented, however I had attempted to integrate agile (more specifically Scrum) practises throughout the completion of this project. 

In order to do so, this involved a Kanban Scrum board, using the Jira software. On this board, I had then developed and placed all User Stories, which would become the base of the Product Backlog; these were based off the project requirements so that they would remain relevant and accurate. Once all product backlog artefacts had been developed and finalised to ensure they cover the entire scope of the project.  

These were then assigned story points in order to gauge the difficulty of the task in accordance to my abilities and the time available; this was done to allow for an estimation on the sprint backlog, as well as preparing me for the task at hand. 

Once all tasks were assigned story points, these were then grouped by epics which would allow for a collation of related backlog items so that they could be grouped. I had set my epics to be grouped by functionality: Create, Read, Update, Delete and Functionality of the application. 

 ![Imgur](https://i.imgur.com/bIqYOCr.png)
 

<h2>Brief Overview of Risk Assessment</h2>

Throughout the course of a project, a Risk Assessment is used in order to increase awareness of potential risks to the outcome of the project, and ultimately prevent/mitigate these as best as possible. 

<h3>Key </h3>

 ![Imgur](https://i.imgur.com/gpjQoME.png)
 
 ![Imgur](https://i.imgur.com/L6bShHT.png)

 
 
<h2>Testing</h2>

Testing for this project had all taken place within Spring Tool Suite (Java Framework) and this involved Integration Testing of larger components building the application and this would provide test coverage for large parts of the application. The integration testing had been completed with JUnit, an inbuilt testing module within Eclipse/Springboot.  

This was with the addition of Unit Testing, which would test individual components of the application, testing each function and writing a test case individualised for the function at hand. This was completed with Mockito as this would use a mock database rather than the inhouse H2 as that would defeat the purpose of testing by sending actual data and polluting the database. 

The overall test coverage of the application can be seen as below: 

![Imgur](https://i.imgur.com/tnQ926m.png)

![Imgur](https://i.imgur.com/VI4tdDf.png) 

As can be seen, the overall coverage had been 84.3% and this is around/above industry standard. However, for a simple application I would have liked for this to be higher. 

Viewing test coverage alone at a glance may seem high, there had been some underlaying issues. The createTask() function would fail all tests despite operating as should, and with Postman also proving this with HTTP Status message 201 Created. The completeTask() function was not tested and thus failed as a result. 

No testing had been carried out on the front-end of this application. 

 

<h2>Front-End Design</h2> 

The front end of this application had been developed with a basic combination of HTML, CSS and JavaScript. This was a simple singular page application where navigation would be simple and all options clear to the user. The button layout, styles and content would clearly show the user of the CRUD functionality within this application. 

Bootstrap and W3schools were both used for CSS styling in styling the front end. 

The main task area would include a list of all tasks entered, each with the clear option to Update or Delete. There had been an attempt for a task to first be sent to a completed section on ‘completed’ button click, however this was not possible within the time restraints of this project and will likely be added as a future feature. 

![Imgur](https://i.imgur.com/x3D1PFc.png)


<h2>Known Issues & Future Improvements </h2>

Due to this being my first experience with a java-based hard coded application, there were bound to be issues and difficulties faced. Although I had attempted to minimalize bugs within the program, a few had found their way through, as I could not solve due to ability or time constraints. 

<ul>
  <li>User is able to press “Update Task” multiple times and cause many update functions to run simultaneously </li>
  <li>No user input sanitation so potential for database to be dropped </li>
  <li>Could not successfully manage to host database on GCP instance </li>
  <li>Test coverage could have been improved and reached 95%+ </li>
  <li>Front-end styling errors, repetitions in code and dead code </li>
</ul>

If this project was to be completed again, as the base concept was understood and full CRUD functionality displayed, I would like to adapt my approach and tackle a slightly more complex idea. For example, a football team builder using drop downs of existing players, providing an up to date team overall rating depending on the ratings of the players selected.  

<ul>
  <li>This could potentially involve more than a single table infrastructure. </li>
  <li>I would also like to host the application on the cloud for optimal up-time and no reliance on host systems.  </li>
  <li>To develop tests for the front end of the application </li>
  <li>User input sanitation for database </li>
</ul>

 

<h2>Author(s)</h2>

Sheraz Shahid 
