# Convenience store management
UIT java app project 07/2021

Use phpmyAdmin and Xampp/Wamp to upload the database with the following name:
- Database's name: quanlycuahang
- Link database: https://drive.google.com/file/d/1mvs94h2Rz3fdCpDEsM6l7g_aAwa_iRWw/view?usp=sharing

## Install necessary apps

1. ### Xampp/Wamp
Xampp or Wamp is used as a local development server. But we recommend to install Xampp since it works with almost platforms like Mac, Linux, Windows, etc,...and Xampp also supports Perl, PHP, MySQL whereas WAMP supports only PHP & MySQL and is not available for Mac.
So, all the steps below will be instructed as using Xampp.
Link download Xampp: https://www.apachefriends.org/download.html
After installing, open "XAMPP Control Panel" and start two modules "Apache" and "MySQL". When two modules turns green it means XAMPP is available.
* If two modules that you have started doesn't turn to green (maybe yellow or red) that means you have some trouble in the default port (80).
* But it doesn't matter! You could solve this problem by the keyword "change XAMPP apache server port".

![](https://imgur.com/ylj93Zm.png)

2. ### NetBeans
NetBeans is an IDE for Java

## Usage

1. ### Step 1:
* Go to the "NetBeansProjects"(find in "Documents").
* Git clone the repo here.

![](https://imgur.com/a76qruS.png)

2. ### Step 2:
* Open the "ConvenienceStoreManagement" project by Netbeans so you could edit codes from now.

![](https://imgur.com/FLzFhdC.png)

![](https://imgur.com/hLkDP9i.png)

3. ### Step 3:
* Access to "http://localhost:80/phpmyadmin"
**Note:** <:80> is a default port when you install XAMPP, but if you have changed XAMPP apache server port, so change 80 as a port that you have edit in config file. 
(Ex: http://localhost:8080/phpmyadmin)

![](https://imgur.com/pXGpgNf.png)

* Create a new database name "quanlycuahang".
* Set db collation as "utf8_unicode_ci"

![](https://imgur.com/HRRzpbW.png)

* Import our database
Link download database: https://drive.google.com/file/d/1mvs94h2Rz3fdCpDEsM6l7g_aAwa_iRWw/view?usp=sharing

![](https://imgur.com/whROZQj.png)

* Finally, click "Go" button.

![](https://imgur.com/neELPK6.png)

3. ### Step 3:
Run
account: truc1831
pass: thanhtruc1831
*Note: You can also see more accounts in "nhanvien" table in "quanlycuahang" database.
<img src="https://media.giphy.com/media/v3R7TwfjRIjRu3Bk8C/giphy.gif" width="900">
