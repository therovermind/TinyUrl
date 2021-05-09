# TinyUrl

##### Discription: 
TinyUrl is URL shortening application where the user can get short url for Big URL's they provide which makes it easy to share it with the world.

##### Backend API:  
There are basically two api's as following:\
    * /api/{url} - This is a Get request in which we have to pass in the url. This returns the short url in JSON format.\
    * /api - This is a POST request in which we send the short url as a requestBody . This returns the original URL for the passed in short Url.
    
##### How To Run:
   - Step1 : Copy the sql script from TinyUrl_backend/src/main/resources and use it to create SQL Database.
   - Step2 : After when SQL database is running then Import TinyUrlBackend in IDE of your choice.
   - Step3 : Run the spring application
   - Step4 : Go to TinyUrl_frontend and open it in terminal. Then run 'npm start'
   - Step5 : Go to localhost:3000/ to use the TinyUrl.

##### To Do: 
   - Backend Test Cases

##### Demo:
