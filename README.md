This application is made up of two parts: server and client. While the server side of the application is responsible for keeping, manipulating and maintaining data, the client side is where the user interacts with and sends requests to the server side. 

1)Database:

The database of the application is made up of 3 tables. These are Contact, Email and Message. 

1.1) The Contact table keeps the contact information and the content of Contact table hold 3 fields. These are id, name and email address. 

1.2) The Email table has id, title and content fields. 

1.3) The Message table, on the other hand, is actually a relationship between Contact and Email. Its primary key is a composite one made up of contact_id, email_id pair. That is, there is one Message entity for any contact & email pair. Apart from that, Message table has two additional fields, which are sendin time and receiving time. 

2) Server:

The server side provides the following REST endpoints: 

2.1) ContactController: Provides create and retrieve operations for the contact information. Available operations are:

2.1.1) GET /contact/{id} : Retrieves a single contact information by contact id.
2.1.2) GET /contact : Retrieves all contact entries in the Contact table.
2.1.3) POST /contact : Adds a single contact information into the table. The contact information will be represented as a JSON object in the request body. 
2.1.4) POST /contact/batch : Adds a list of contacts into the table. Again, the Contact objects are found in the request body.

2.2) EmailController:

2.2.1) GET /email/{id} : Retrieves email by id.
2.2.2) GET /email : Retrieves all emails.
2.2.3) POST /email : Adds new email into the database. Email information is kept in the request body.

2.3) MessageController:

2.3.1) POST /message : When the user sends an email to a given contact, a request is made to this endpoint. A Message entry made up of contact_id, email_id and sending time is created and added into the database. At the beginning, receive time field of the Message entry will be -1, as it will be initialized once the contact clicks the link in the email. 

2.3.2) GET /message/{contact_id}/{email_id} : Retrieves a given message identified by contact id and email id. 

2.3.3) GET /message/read/{contact_id}/{email_id} : This request is invoked when the contact clicks the link in the email. The path variable contact_id is the corresponding contact's id and email_id is the email's id. When this request is made, the corresponding Message entry will be retrieved and the receive time will be checked. If the receive time is -1, is is updated to become the current time so that we can know the first click time. If not, it means that the contact has already clicked the link and hence receive time is not updated.

2.3.4) GET /message : Retrieves all messages in the database.

3) Client

When the user uploads a contact list file as described in the specifications, the client side parses the file and Contact informations are created for each of the lines in the file. Then, the request POST /contact/batch is made where the contact informations are embedded into the request body. As response, uploaded contacts are returned and showed to the user.

When the user composes an email and sends it to the selected contacts, the followings happen:

1) An email object is created and POST /email request is made to the server side. 
2) Since the request above returns the object's representation as response, it is now possible to create Message entries for all of the selected contacts. Message objects are created for each one of the contacts and sending time is set to the current time. Finally, for each those Message objects, requests are made to POST /message to save those massages in the database.

When contacts receive the email, they click on their custom link. When clickin happens, a request is made to GET /message/read/{contact_id}/{email_id}. As described above, mail receive time is updated if it is the first time click. Other than that, a response body made up of a simple JSON object will be returned to the contact. That JSON object will have the given contact's name.

Finally, the client side can make a GET /message/ request to retrieve all messages. The Message table includes the information of: which contacts are sent which emails, sending timestamp for each of the messages and also the receiving timestamp. If receive time for a given message is -1, it means that the contact has not yet clicked the link and hence the client uses this information to show that the contact has not yet clicked the link. On the other hand, if receive time is not -1, then the client subtracts sending time from receive time to compute how long it took for the contact to click the link.

Note: For simplicity, the message composition time is used as the message receive time by the contact. The receive time field in the Message table actually represents the link click time. 