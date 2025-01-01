# Overview

Repository to track development and details about Spring MVC

## Notes

1. SprintBoot searches the following directories for static resources all under ```/src/main/resources/``` in given priority: <br>
    - /META-INF/resources
    - /resources
    - /static
    - /public
2. Components of Spring MVC application
    - **Web pages**: A set of web pages to layout UI components.
    - **Beans**: A collection of Spring Beans (controllers, services, etc.)
    - **Spring Configuration**: Spring configurations (XML, Annotations or Java class configurations)
3. Spring MVC flow
   ![Spring MVC Flow](./img/springMVCFlow.png "Spring MVC Flow")
    - **Front Controller**: Delegates requests to other objects in our system such as controller functions.
    - **Controller**: Code created by Developer. It contains business logic like:
      - Handles request
      - Store/retrieve data (db, web service)
      - Place data into Model
      - Send flow to appropriate view template
    - **Model**: Contains data which was retrieved and stored in Model object. Data in Model can be any Java object/ Collection.
    - **View Template**: SpringBoot supports different types of view template such as Groovy, Velocity, Freemarker, Thymeleaf etc. 
    which is processed and returned to user.
4. Parameters to controller functions.  
   We can pass the parameter of Model if we want to use model in our controller method.  
   Similarly, we can pass HttpServletRequest parameter to our controller method if we want to get information related to the request.
   ```java
      @RequestMapping("/processFormVersionTwo")
      public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String message = "Yo! "+name;

        model.addAttribute("message", message);

        return "helloworld";
      }
   ```
   The data in the model can be access using ```${modelAttributeName}```  
   ```html
       <!DOCTYPE HTML>
       <html lang="en-US" xmins:th="http://www.thymelead.org"
         xmlns:th="http://www.w3.org/1999/xhtml" xmlns:xmins="http://www.w3.org/1999/xhtml">
           <head>
               <title>Thymeleaf Demo</title>
           </head>
           <body>
               Hello World of Spring!
               <br><br>
               Student name: <span th:text="${param.studentName}"></span>
               <br><br>
               The message: <span th:text="${message}"></span>
           </body>
       </html>
    ```
   *param is value present in Model which contains form data associated to the request*
