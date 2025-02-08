**Twitter Clone** 🐦

A simple Twitter clone built using Spring MVC, Java, Thymeleaf, HTML, CSS, and JavaScript. It allows users to register, log in, post tweets, retweet, and view their profile.

.

**📌 Features**

✔ User Registration & Login (Session-based authentication)

✔ Post Tweets & Retweet

✔ Profile Page with User Tweets

✔ Responsive Design

✔ Scrollable Tweet Feed

.



**🖥️ Pages & Their Functions**


1️⃣ Home Page (home.html)


🔹 Displays all tweets from users in a scrollable box

🔹 Users can post new tweets

🔹 Retweet option available

<img width="1439" alt="home-page" src="https://github.com/harshita-12/twitter_clone/blob/main/preview/home_page.png">


2️⃣ Login Page (login.html)

🔹 Allows users to log in with their username and password

🔹 Uses session handling for authentication

<img width="1439" alt="login-page" src="https://github.com/harshita-12/twitter_clone/blob/main/preview/login_page.png">


3️⃣ Sign-up Page (register.html)

🔹 Users can sign up with name, email, password, and gender

<img width="1439" alt="signup-page" src="https://github.com/harshita-12/twitter_clone/blob/main/preview/signup_page.png">



4️⃣ Profile Page (profile.html)

🔹 Displays user-specific tweets

<img width="1439" alt="profile-page" src="https://github.com/harshita-12/twitter_clone/blob/main/preview/profile_page.png">

 .

 
**📂 Project Structure**

twitter-clone/

│-- src/main/java/com/twitterclone/

│   ├── controller/       # Controllers for handling requests  
│   ├── model/            # Entity models (User, Tweet)  
│   ├── repository/       # Data repositories (JPA)  
│   ├── service/          # Business logic services  
│-- src/main/resources/templates/  
│   ├── home.html         # Home page (shows tweets)  
│   ├── profile.html      # User profile page  
│   ├── login.html        # Login page  
│   ├── register.html     # Registration page  
│-- src/main/resources/static/css/style.css  # Stylesheet  
│-- pom.xml               # Maven dependencies  
│-- application.properties  # Database configuration  


.
 
**Created by Harshita Arun**

📅 Year: 2024 | 🔥 Project Type: Spring MVC
