## Introduction

 -  create a new Spring Boot project with Gradle
     -  Dependencies: Web, Thymeleaf
     -  Optional dependencies: Lombok, DevTools
 -  create an `index.html` file in the `src/main/resources/static/` folder
 -  reproduce [the static information view](assets/views/information-00.png)
     -  download [the fox](assets/greenfox.png)
 -  start your application, navigate to `localhost:8080`
 -  if it works then you are good to go
 -  create a `MainController.class` file where you will store all your
    navigation routes
 -  move your html file to `src/main/resources/templates` folder
 -  create a `/` route
     -  fix the `index.html` file so that it works
     -  restart your application, navigate to `localhost:8080`
     -  if it works then you are good to go

## Login Page

 -  we need to have login page thus receiving the name of the actual pet
 -  create `login.html` and reproduce this [login page](assets/views/login.png)
 -  the input field should be a form and should send the value of `name` field  of the `Fox.class` (for further explanations see below)
 -  create 2 `/login` endpoint (GET and POST)
 -  GET method should render the `login.html`
 -  POST method should receive `name` value as @RequestParam [like this](assets/views/information-01with-login.png), then it should redirect to the main page `/` with the value of the @RequestParam
 -  from now on every endpoint should require this @RequestParam (by default it is required)
 -  optional: in case the given parameter value is a new one, the program should redirect to login
 -  optional: in case there is no given parameter in the path the program should automatically redirect to login
 -  optional: show error message with red on the login page i.e.: "You have provided a name that has not been used before, add it as a new one!"

## Information Page
 -  create a `Fox.class`
     -  it should represent a virtual fox
     -  it should have at least the followings: name, list of tricks, food
        and drink
     -  consider using more classes or enums
 -  add a new Fox (created with the received name) to a list of Foxes
 -  find the actual fox based on the name and send it to the template model
 -  use Thymeleaf to replace the data
 -  if the fox does not know any tricks yet, display a message instead of
    an empty list
 -  if the fox's name is *Mr. Green*, eats *salad*, drinks *water* and knows
    *0* trick, [the updated information view](assets/views/information-01.png)
    should represent that

## Nutrition Store

 -  create a `/nutritionStore` route
 -  create [the nutrition store view](assets/views/nutrition_store.png)'s
    template
     -  do not forget to add this to the menu on the other views
 -  here you should be able to change the fox's food and drink
     -  feel free to add your own foods and drinks
     -  you might need additional routes to achieve this
     -  create an other controller for those (eg. `FoxController.class`)
 -  when the button is pressed it should redirect to the information page
 -  optional: the current food and drink are selected by default

## Trick Center

 -  create a `/trickCenter` route
 -  create [the trick center view](assets/views/trick_center.png)'s template
 -  it should list the tricks
     -  feel free to add your own tricks
 -  one trick could be learned only once
 -  optional: do not list the tricks that have been learned already
 -  optional: if all the tricks have been learned display a message
    instead of the dropdown

## Optional

### Action History

 -  create a `/actionHistory` route
 -  here you should display all the actions that have been made
    *(eg. food change)*
 -  if no actions were made yet display a message else list all the actions
 -  create [the action history view](assets/views/action_history.png)'s template
 -  display the five latest actions to the information page
     -  upgrade [the information view](assets/views/information-02.png)

### Other ideas

 -  add amount to food and drink that decreases over time
 -  be able to play the tricks
     -  display different image based on the trick
 -  add a little design
 -  add anything else if you have time 😉