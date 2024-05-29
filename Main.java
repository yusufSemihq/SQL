WHERE VE KARŞILAŞTIRMA OPERATÖRLER

//SELECT <sütun_adı>, <sütun_adı>, ...
//FROM <tablo_adı>
//WHERE <koşul>;
//Eğer tablodaki tüm sütunlardaki verileri çekmek istersek asteriks * karakterinden faydalanırız.


//SELECT *
//FROM <tablo_adı>;




//SELECT title, replacement_cost
//FROM film
//WHERE replacement_cost = 14.99;
//Bu sorgumuzda dvdrental veritabanında bulunan film tablosundaki title ve replacement_cost sütunlarında bulunan verileri çekiyoruz ancak bu kez tüm verileri değil replacement_cost = 14.99 koşulunu sağlayan verileri alıyoruz.



WHERE VE MANTIKSAL OPERATÖRLER


//SELECT *
//FROM actor 
//WHERE first_name = 'Penelope' AND last_name = 'Monroe' ;
//Bu sorgumuzda dvdrental veritabanında bulunan actor tablosundaki tüm sütunlarında bulunan verileri çekiyoruz ancak bu kez iki koşulumuz var. 
//AND operatörünün true sonucu dönmesi için bu iki koşulumuzun da sağlanması gerekiyor. Sıralanacak verilerin first_name sütunundaki değeri 'Penelope' ve last_name sütunundaki değerinin 'Monroe' olması gerekmektedir.



//SELECT *
//FROM actor 
//WHERE first_name = 'Penelope' OR first_name = 'Bob' ;
//Bu sorgumuzda dvdrental veritabanında bulunan actor tablosundaki tüm sütunlarında bulunan verileri çekiyoruz ancak bu kez iki koşulumuz var. OR operatörünün true sonucu dönmesi için bu iki koşulumuzunda herhangi birinin sağlanması yeterlidir. 
//Sıralanacak verilerin first_name sütunundaki değeri 'Penelope' veya 'Bob' olması gerekmektedi




//SELECT *
//FROM film 
//WHERE NOT rental_rate = 4.99 ;
//Bu sorgumuzda dvdrental veritabanında bulunan film tablosundaki tüm sütunlarında bulunan verileri çekiyoruz ancak bu kez koşulumuzu NOT yani değil mantıksal operatörü yardımıyla oluşturmuşuz. NOT operatörü bize verilerin hangi koşul dışı olduğunu gösterir. 
//Örneğimizin senaryosu; Film tablomuzda bulunan tüm sütunlardaki verileri sıralayacağız ancak bu verilerin rental_rate sütununda bulunan değerleri 4.99' a eşit OLMAYACAK!



//SELECT *
//FROM film 
//WHERE NOT (rental_rate = 4.99 OR rental_rate = 2.99)
//Mantıksal operatörleri sıklıkla birlikte kullanırız. Yukarıdaki örneğimizde sıralayacağımız verilerin rental_rate sütunlarında bulunan değerlerinin 4.99 veya 2.99 olmamasını istiyoruz.




BETWEEN VE IN

//SELECT * FROM film
//WHERE length >= 100 AND length <= 140;
//Aşağıdaki sorgumuzda AND mantıksal operatörü yardımıyla film tablosunda bulunan verilerimizi uzunluğu 140 tan küçük eşit VE 100 den büyük eşit olmak üzere sıralıyoruz.



//BETWEEN AND Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>, ... FROM <tablo_adı>
//WHERE <koşul>;


//SELECT * FROM film
//WHERE length BETWEEN 100 AND 140; -- WHERE length >= 100 AND length <= 140 ifadesi ile aynı sonucu verir.
//Burada dikkat edilmesi gereken nokta 100 ve 140 sınır değerleri aralığa dahildir.


//SELECT * FROM film
//WHERE length = 30 OR length = 60 OR length = 90 OR length = 120;
//Şöyle bir senaryo düşünelim, yine film tablosundan uzunluğu 30, 60, 90 veya 120 dakikaya eşit olan verileri sıralayalım.sorgusuyla verileri aldık ancak burada şöyle bir sorunumuz var peki 4 farklı değer için değil 14 farklı değer için bu sorgumuzu gerçekleştirmek için 14 ayrı OR mantıksal operatörü kullanmamız gerekirdi.
//Bunun yerine istenilen değerleri liste haline geitip IN anahtar kelimesiyle kullanabiliriz.



LIKE VE ILIKE
//SELECT *
//FROM actor
//WHERE first_name = 'Penelope';
//Aşağıdaki sorgumuzda actor tablomuzda bulunan tüm sütunlardaki verileri first_name sütununda ki değeri 'Penelope' olmak üzere getiriyoruz.


//SELECT *
//FROM actor
//WHERE first_name LIKE 'P%';
//Ancak bizler bazı durumlarda bu şekilde tam eşleşme değil belirli şablonlara uyan koşulların sağlanmasını isteriz. Örneğin aşağıdaki sorgumuzda first_name sütunun 'Penelope' değerine eşit olmasını değil, ilk harfin 'P' olması koşulunu sağlar. 
//Bunun için LIKE operatörünü kullanırız.



//LIKE Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>, ...
//FROM <tablo_adı>
//WHERE <sütun_adı> LIKE <şablon>;	





DISTINCT VE COUNT

DISTINCT
//Şimdiye kadar yaptığımız SQL sorgularında genellikle verileri belirli koşullar altında sıraladık. Dikkat ettiyseniz bir çok durumda aynı sütün içerisinde birbirinin aynı olan veriler ile karşılaştık.
//Örneğin dvdrental veritabanı içerisinde bulunan film tablosundaki replacement_cost, rental_rate gibi sütunlar birbirini tekrar eden verilerden oluşmaktadır. Bazı durumlarda bir sütun içerisinde bulunan farklı değerleri görmek isteriz.
//sorgusu bize rental_rate sütununda bulunan birinden farklı 2.99, 0.99, 4.99 verilerini gösterir.
//SELECT DISTINCT rental_rate 
//FROM film;



SELECT DISTINCT Söz Dizimi
//SELECT DISTINCT <sütun_adı>, <sütun_adı>, ...
//FROM <tablo_adı>


COUNT
//COUNT aggregate fonksiyonu ilgili sorgu sonucunda oluşan veri sayısını bildirir. Aşağıdaki sorguda ismi 'Penelope' olan aktörleri sıralıyoruz.
//SELECT * 
//FROM actor
//WHERE first_name = 'Penelope';



//ancak veri sayısını bulmak istersek COUNT fonksiyonunu kullanırız.
//SELECT COUNT(*)
//FROM actor
//WHERE first_name = 'Penelope';
//Yukarıda da belirttiğimiz gibi COUNT fonksiyonu ile sorgu sonucunda ortaya verileri sayıyoruz. Bu nedenle COUNT(*) veya COUNT(sütun_adı) aynı sonucu verir.



PSQL ve Uygulama I

//psql -U <kullanıcı_adı>
//PSQL ile PostgreSQL'e bağlanmak.

//postgres=#
//Kullanıcıya ait şifreyi girdikten sonra varsayılan veritabanı postgres'e bağlanıyor.

//\l veya \list
//Bulunan veritabanlarını listelemek için:

//\c dvdrental veya \connect dvdrental
//Bizim örneğimizde dvdrental veritabanına bağlanacağız.

//\dt
//Bağlanılan dvdrental veritabanında bulunan tabloları listelemek için:

//\d <tablo_adı>
//Herhangi bir tablonun sütunlarını ve tablo detaylarını görmek için:

//SELECT * FROM customer
//WHERE first_name LIKE 'A%' AND last_name LIKE 'A%';
//customer tablosunda bulunan first_name değeri ve last_name değeri 'A' karakteri ile başlayan verileri sıralayınız.

//SELECT * FROM film
//WHERE (length BETWEEN 80 AND 120) AND (rental_rate IN (0.99, 2.99));
//film tablosunda bulunan ve uzunluğu 80 ile 120 arasında bulunan ve aynı zamanda rental_rate değeri 0.99 veya 2.99 olan verileri sıralayınız.

//\q
//PSQL terminal ekranından çıkmak için



ORDER BY
ORDER BY Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>, ...
//FROM <tablo_adı>
//ORDER BY <sütun_adı>, <sütun_adı>, ... ASC|DESC;


//SELECT *
//FROM film
//ORDER BY title (ASC);
//Bu sorgumuzda dvdrental veritabanında bulunan film tablosundaki tüm sütunları title sütununda bulunan verilere göre artan (ASC) şeklinde sıralıyoruz.


//SELECT *
//FROM film
//ORDER BY title ASC length DESC;
//ASC sıralama varsayılan olduğu için ayrı bir şekilde yazılması zorunluluğu yoktur ancak sorguyu belirginleştirmesi açısından genelde yazılır.


//SELECT *
//FROM film
//WHERE title LIKE 'A%'
//ORDER BY title ASC length DESC;
//Sıralama birden fazla sütuna göre de yapılabilir. Yukarıdaki örneğimizde sıralama title sütununa göre artan length sütununa göre azalan şeklinde yapılıyor.



LIMIT ve OFFSET
LIMIT
//Şimdiye kadar yaptığımız SQL sorgularında genellikle verilerin tamamını belirli koşullar altında sıraladık. Bazı durumlarda ise koşullarımızı sağlayan verilerin tamamını değil belirli sayıda olanlarını sıralamak isteriz, bunun için LIMIT anahtar kelimesini kullanırız.
//Şöyle bir senaryo üzerine düşünelim. dvdrental veritabanında bulunan film tablosundan B ile başlayan filmleri uzunluklarına göre en uzun olan 10 filmi sıralayalım.
//SELECT *
//FROM film
//WHERE title LIKE 'B%'
//ORDER BY length DESC
//LIMIT 10;



OFFSET
//Bazı durumlarda sonuç olarak gördüğümüz veri grubu içerisinden bazılarını "pass" geçmek isteriz. Yukarıdaki senaryomuzu tekrar düşünelim, dvdrental veritabanında bulunan film tablosundan B ile başlayan filmleri uzunluklarına göre sıralayalım ancak en uzun 6 filmi "pass" geçelim ve sonrasındaki 4 filmi sıralayalım.
//Bu durumda LIMIT 4 ve OFFSET 6 olacak.
//SELECT *
//FROM film
//WHERE title LIKE 'B%'
//ORDER BY length DESC
//OFFSET 6
//LIMIT 4;



Aggregate Fonksiyonlar - MIN, MAX, SUM, AVG

//AVG fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun ortalama değerini alırız.
//SELECT AVG(length) 
//FROM film;


//sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin ortalamasını alırız. SUM fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun toplam değerini alırız.
//SELECT SUM(length) 
//FROM film;


//sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin toplamını alırız. MAX fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun en yüksek değerini alırız.
//SELECT MAX(length) 
//FROM film;


//sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin en yüksek değerini alırız. MIN fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun en düşük değerini alırız.
//SELECT MIN(length) 
//FROM film;



GROUP BY

//Bizler şimdiye kadar olan sorgularımızın tamamında sorguları yaparken genel veri kümesinin tamamı üzerine düşündük, ancak bazı durumlarda aynı sonuçları veri kümesinin içerisinde bulunan farklı gruplarda da bulmak isteyebiliriz.
// Senaryomuzu şu şekilde düşünelim, dvdrental veritabanında rental_rate sütununda bizim 3 farklı değerimiz var 
//(0.99, 2.99, 4.99). Biz bu 3 farklı değer için en uzun filmi bulmaya çalışalım. 
//SELECT MAX(length) FROM film
//WHERE rental_rate = 0.99;
//SELECT MAX(length) 
//FROM film
//WHERE rental_rate = 2.99;
//SELECT MAX(length) 
//FROM film
//WHERE rental_rate = 4.99;




GROUP BY Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>, ... (veya aggregate func) FROM <tablo_adı>
//GROUP BY <sütun_adı>, <sütun_adı>, ...
//Burada şuna dikkat etmemiz gerekir, SELECT anahtar kelimesinde bulunan sütunların GROUP BY anahtar kelimesi içerisinde bulunması gerekir.



GROUP BY Örnek Kullanım
//Yukarıdaki senaryomuzu GROUP BY anahtar kelimesini kullanarak gerçekleştirelim. Dikkat ettiğiniz üzere SELECT ile kullanılan rental_rate sütunu GROUP BY satırında da kullanılmıştır.
//SELECT rental_rate, MAX(length) FROM film
//GROUP BY rental_rate;




HAVING
//HAVING anahtar kelimesi sayesinde gruplandırılmış verilere koşullar ekleyebiliriz. Hemen aklımıza WHERE anahtar kelimesi geldi değil mi? Ancak WHERE anahtar kelimesi ile biz satır bazlı koşullar verebiliyoruz.
//Şöyle bir senaryomuz olsun. Her bir rental_rate oranına karşılık gelen film sayısını bulalım. Bunu GROUP BY ile gerçekleştirebiliriz. Ancak bu kez 1 adım öteye gidip şöyle bir koşul ekleyelim toplam film sayısı 325 ten fazla olan rental_rate oranlarını görelim.
//u durumda GROUP BY ile elde ettiğimiz toplam film sayılarına koşul eklememiz gerekir.
//SELECT rental_rate, COUNT(*) FROM film GROUP BY rental_rate HAVING COUNT(*) > 325;





ALIAS (AS)
//AS anahtar kelimesi sayesinde sorgular sonucu oluşturduğumuz sanal tablo ve sütunlara geçici isimler verebiliriz.

//ALIAS SÜTUN KULLANIMI

//SELECT <sütun_adı> AS <geçici_ad>
//FROM <tablo_adı>;
//ALIAS TABLO KULLANIMI

//SELECT <sütun_adı>, <sütun_adı>...
//FROM <tablo_adı> AS <geçici_ad>;






Tablo Oluşturmak ve Silmek (CREATE - DROP)
Tablo Oluşturmak - CREATE
//SQL ile yeni bir tablo oluşturmak için CREATE anahtar kelimesi kullanılır. Tablo oluştururken sonrasında daha detaylı konuşacağımız 3 önemli başlık daha vardır.

//Sütunlara verilecek isim, sütunların veri tipi ve varsa sütunlarda bulunan kısıtlama yapıları.

//Tablo Oluşturmak - CREATE Söz Dizimi
//CREATE TABLE <tablo_adı> (
  //  <sütun_adı> <veri_tip> (kısıtlama_adı>,
    //<sütun_adı> <veri_tip> (kısıtlama_adı>,
//   ....
//);



//Tablo Oluşturmak - CREATE Örnek Kullanım
//author isminde bir tablo oluşturalım, id, first_name, last_name, email, birthday sütunları olsun. Veri tipleri ve kısıtlama yapılarıyla ilgili sonrasında detaylı olarak konuşacağız.

//CREATE TABLE author (
//  id SERIAL PRIMARY KEY,
//  first_name VARCHAR(50) NOT NULL,
//  last_name VARCHAR(50) NOT NULL,
//  email VARCHAR(100)
//  birthday DATE
//);




//Tablo Silmek - DROP
//Oluşturduğumuz tabloları silmek için DROP anahtar kelimesi kullanılır.




//Tablo Silmek - DROP Söz Dizimi
//DROP TABLE (IF EXISTS) <tablo_adı>;
//Burada IF EXISTS yapısını kullanarak yanlış tablo ismi yazımı durumunda hata mesajı almayı önleriz.





//Tablo Silmek - DROP Örnek Kullanım
//"test" isimli tablomuzu silmek istersek;
//DROP TABLE IF EXISTS test;




TABLO VERİLERİNİ GÜNCELLEMEK (UPDATE - DELETE)
//Bir tabloda bulunan verileri güncellemek veya silmek için öncelikle örnek bir tablo oluşturup içine 5 date veri yerleştireceğim.

//Bunun için Mockaroo benzeri servisleri kullanabiliriz. Aşağıdaki örnek tablo oluşturma ve veri girme komutlarını bulabilirsiniz.

//CREATE TABLE my_apps (
//	id INT,
//	name VARCHAR(50),
//	price VARCHAR(50)
//);
//INSERT INTO my_apps (id, name, price) values (1, 'Ronstring', '$0.96');
//INSERT INTO my_apps (id, name, price) values (2, 'Duobam', '$3.44');
//INSERT INTO my_apps (id, name, price) values (3, 'Tresom', '$2.21');
//INSERT INTO my_apps (id, name, price) values (4, 'Redhold', '$2.52');
//INSERT INTO my_apps (id, name, price) values (5, 'Y-find', '$9.14');


UPDATE
//UPDATE anahtar kelimesi sayesinde tablomuzda bulunan verileri güncelleyebiliriz.

UPDATE SÖZ DİZİMİ
//UPDATE <tablo_adı>
//SET <sütun_adı> = değer, 
//    <sütun_adı> = değer,
//    ----
//WHERE <koşul_adı>;


UPDATE Örnek Kullanım
//my_apps tablosunda bulunan ve id 2' ye eşit olan verimizin name sütunundaki degerini 'Mayak' price sütunundaki değerini '$5.22' ile değiştirelim.

//UPDATE my_apps
//SET name = 'Mayak',
//	price = '$5.22'
//WHERE id = 2;



DELETE
//DELETE anahtar kelimesi sayesinde tablomuzda bulunan verileri silebiliriz.

DELETE SÖZ DİZİMİ
//DELETE FROM <tablo_adı>
//WHERE <koşul_adı>



DELETE Örnek Kullanım
//my_apps tablosunda bulunan name sütunundaki verisi 'Tresom' olan satırı silelim.

//DELETE FROM my_apps
//WHERE name = 'Tresom'




ALTER ve NOT NULL
NOT NULL

//Birçok durumda bizler herhangi bir sütuna yazılacak olan verilere belirli kısıtlamalar getirmek isteriz. 
//Örneğin yaş sütünunda sadece sayısal verilerin olmasını isteriz ya da kullanıcı adı sütununda bilinmeyen (NULL) değerlerin olasını istemeyiz. Bu gibi durumlarda ilgili sütunda CONSTRAINT kısıtlama yapıları kullanılır.


NOT NULL Kullanımı

//Employees şeklinde bir tablomuzu oluşturalım. Tablodaki first_name ve last_name sütunlarında bilinmeyen veri istemiyoruz, bu sütunlarda NOT NULL kısıtlama yapısı kullanabiliriz.



//CREATE TABLE Employees (     id SERIAL PRIMARY KEY,
//   first_name VARCHAR(100) NOT NULL,
//   last_name VARCHAR(100) NOT NULL,
//   age INTEGER
//);




ALTER ve NOT NULL

//ALTER anahtar kelimesini varolan bir tabloda değişiklik yapmak için kullanılır. Aşağıdaki senaryoda bir sütuna NOT NULL kısıtlaması vermek için aşağıdaki söz dizimi yapısı kullanılır.

//ALTER TABLE <tablo_adı> ALTER COLUMN <sütun_adı>
//SET NOT NULL;





UNIQUE

//UNIQUE kısıtlaması ile uyguladığımız sütundaki verilerin birbirlerinden farklı benzersiz olmalarını isteriz. PRIMARY KEY kısıtlaması kendiliğinden UNIQUE kısıtlamasına sahiptir.





//UNIQUE Kullanımı

//Employees şeklinde bir tablomuzu oluşturalım. Tablodaki email sütununda bulunan verileri UNIQUE olarak belirlemek istersek.

//CREATE TABLE Employees (     ---
//    emaile VARCHAR(100) UNIQUE,
//    ----
//);



ALTER ve UNIQUE

//ALTER TABLE <tablo_adı> ADD UNIQUE <sütun_adı>

//Bu arada herhangi bir sütuna UNIQUE kısıtlaması getirirsek ve öncesinde UNIQUE olmayan verileri kaldrmamız gerekir.





CHECK
//CHECK kısıtlaması ile uyguladığımız sütundaki verilere belirli koşullar verebiliriz.
//Örneğin age (yaş) olarak belirlediğimiz bir sütuna negatif değerler verebiliriz veya web portaline üye olan kullanıcıların yaşlarının 18 yaşından büyük olması gibi kendi senaryolarımıza uygun başka kıstlamalar da vermek isteyebiliriz.

CHECK Kullanımı
//Employees şeklinde bir tablomuzu oluşturalım. Tablodaki age sütununda bulunan verilerin 18'e eşit veya büyük olmasını istiyoruz.

//CREATE TABLE Employees (     ---
//    age INTEGER CHECK (age>=18)
//    ----
//);

ALTER ve CHECK
//ALTER TABLE <tablo_adı> ADD CHECK (age>=18)





PSQL ve Uygulama II
PSQL

//PSQL, PostgreSQL ile birlikte gelen terminal tabanlı bir kullanıcı arayüzüdür. PSQL sayesinde komut satırında sorgular yazıp, sonuçlarını görebiliriz. Aşağıda temel PSQL komutlarının ilk bölümünü bulabilirsiniz.

//psql -h <host_name> -p <port_name> -U <kullanıcı_adı> <veritabanı_adı>
//PSQL ile PostgreSQL'e host, port, kullanıcı adı ve veritabanı ismi ile bağlanmak için


//CREATE DATABASE <veritabanı_adı>
//Yeni veritabanı oluşturmak için

//CREATE TABLE <tablo_adı> (   <sütun_adı> VERİ TİPİ (KISITLAMA)
//  ----
//Yeni tablo oluşturmak için


//\d+ <tablo_adı>
//Tablo detaylarını görmek için


//Bir tablodaki sütun ismini değiştirmek için
//ALTER TABLE <tablo_adı> RENAME COLUMN <sütun_adı> TO <yeni_sütun_adı>

//.Bir sütuna UNIQUE kısıtlaması eklemek için
//ALTER TABLE <tablo_adı> ADD CONSTRAINT <kısıtlama_adı> UNIQUE <sütun_adı>




JOIN Kavramı (Birleştirme)

//Veraitabanları çoğunlukla birbiri ile ilşkili olan tablolardan oluşur. Bu birbiri ile ilişkili olan tablardaki verileri farklı JOIN yapıları kullanarak sanal olarak birleştirip daha anlamlı veriler haline getirebiliriz.



INNER JOIN

//INNER JOIN yapısı sayesinde birbiriyle ilişkili olan tabloların birbiriyle eşleşen (kesişen) verilerini sıralayabiliriz.

//Aşağıdaki SQL sorgusunda kitap isimlerini yazar isim ve soyisimler ile birlikte gösterebiliriz.
//SELECT book.title, author.first_name, author.last_name
//FROM book
//JOIN author ON author.id = book.author_id;


//SELECT <sütun_adı>, <sütun_adı> ...
//FROM <tablo1_adı>
//INNER JOIN <tablo2_adı>
//ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;

//Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.




//LEFT JOIN
//LEFT JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi tablo 1 (soldaki tablo) üzerinden gerçekleştirilir.



//Aşağıdaki SQL sorgusunda kitap isimlerinin tamamını alıyoruz, sonrasında bu kitap isimleriyle eşleşebilen yazar isimlerini alıyoruz. Kitap isimlerine karşılık olmayan yazarlar için NULL değeri alıyoruz.

//SELECT book.title, author.first_name, author.last_name FROM book
//LEFT JOIN author
//ON author.id = book.author_id;



LEFT JOIN Söz Dizimi

//SELECT <sütun_adı>, <sütun_adı> ... FROM <tablo1_adı>
//LEFT JOIN <tablo2_adı>
//ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;

//Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.




RIGHT JOIN
//RIGHT JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi tablo 2 (sağdaki tablo) üzerinden gerçekleştirilir.


//Aşağıdaki SQL sorgusunda yazar isim ve soyisim bilgilerinin tamamını alıyoruz, sonrasında eşleşebilen kitap isimlerini alıyoruz. Yazar bilgilerine karşılık olmayan kitap isimleri için NULL değeri alıyoruz.

//SELECT book.title, author.first_name, author.last_name
//FROM book
//RIGHT JOIN author
//ON author.id = book.author_id;


RIGHT JOIN Söz Dizimi

//SELECT <sütun_adı>, <sütun_adı> ...
//FROM <tablo1_adı>
//RIGHT JOIN <tablo2_adı>
//ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
//Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.




FULL JOIN
//Full JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi her iki tablo üzerinden gerçekleştirilir

//Aşağıdaki SQL sorgusunda kitap isimlerinin tamamını alıyoruz, sonrasında yazar isimlerini alıyoruz. Eşleşemeyen veriler için NULL değeri alıyoruz.
//SELECT book.title, author.first_name, author.last_name FROM book
//FULL JOIN author
//ON author.id = book.author_id;



FULL JOIN Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı> ... FROM <tablo1_adı>
//FULL JOIN <tablo2_adı>
//ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
//Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.



UNION
//UNION operatörü sayesinde farklı SELECT sorgularıyla oluşan sonuçları tek bir sonuç kümesi haline getiririz.



UNION Kullanımı
//bookstore veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz. UNION anahtar kelimesi sayesinde bu iki sorguyu da birleştirebiliriz.



//( SELECT * 
//FROM book
//ORDER BY title
//LIMIT 5
//)
//UNION
//(
//SELECT * 
//FROM book
//ORDER BY page_number DESC
//LIMIT 5
//);
//UNION operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.

UNION Söz Dizimi


//SELECT <sütun_adı>, <sütun_adı>... FROM <table1>
//UNION
//SELECT <sütun_adı>, <sütun_adı>...
//FROM <table2>


UNION ALL
//UNION operatörü bize birleşik veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için UNION ALL kullanırız.


INTERSECT ve EXCEPT
//INTERSECT operatörü sayesinde farklı SELECT sorgularıyla oluşan sonuçların kesişen verilerini tek bir sonuç kümesi haline getiririz.



INTERSECT Kullanımı
//bookstore veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz.


//( SELECT * 
//FROM book
//ORDER BY title
//LIMIT 5
//)
//INTERSECT
//(
//SELECT * 
//FROM book
//ORDER BY page_number DESC
//LIMIT 5
//);
//INTERSECT operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.



INTERSECT Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>... FROM <table1>
//INTERSECT
//SELECT <sütun_adı>, <sütun_adı>...
//FROM <table2>




INTERSECT ALL
//INTERSECT operatörü bize kesişen veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için INTERSECT ALL kullanırız.



EXCEPT Kullanımı
//bookstore veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz.
//( SELECT * 
//FROM book
//ORDER BY title
//LIMIT 5
//)
//EXCEPT
//(
//SELECT * 
//FROM book
//ORDER BY page_number DESC
//LIMIT 5
//);
//EXCEPT operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.


EXCEPT Söz Dizimi
//SELECT <sütun_adı>, <sütun_adı>... FROM <table1>
//EXCEPT
//SELECT <sütun_adı>, <sütun_adı>...
//FROM <table2>

EXCEPT ALL
//EXCEPT operatörü bize ilk sorguda olan ancak ikinci sorguda olmayan veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için EXCEPT ALL kullanırız.




Alt Sorgular (Subqueries)
//Bir sorgu içerisinde, o sorgunun ihtiyaç duyduğu veri veya verileri getiren sorgulardır.


Alt Sorgu Kullanımı
//bookstore veritabanında "Gülün Adı" isimli kitabımızın sayfa sayısı 466 dır. Bu kitaptan daha fazla sayıda sayfası bulunan kitapları aşağıdaki sorgu yardımıyla sıralayabiliriz.
//SELECT * FROM book
//WHERE page_number > 466;


//Ancak yukarıdaki sorgumuzda şöyle bir sorun var. 466 ifade statik bir ifade ve biz bu değeri bilmiyor olabiliriz. Bu nedenle buradaki 466 rakamını aşağıdaki sorgu yardımıyla bulabiliriz.
//SELECT page_number FROM book
//WHERE title = 'Gülün Adı'


//İşte bu ikinci sorgumuz ilk sorgumuzda bir alt sorgu görevi görebilir. Her iki sorguyu da birleştirelim.
//SELECT * FROM book
//WHERE page_number >
//(
//SELECT page_number
//FROM book
//WHERE title = 'Gülün Adı'
//);




Any ve All Operatörleri
//Any ve All operatörleri alt sorugularda sıklıkla kullanılır ve tek bir sütunda bulunan bir değerle bir değer dizisinin karşılaştırılmasını sağlar.


ANY Operatörü
//Alt sorgudan gelen herhangi bir değer koşulu sağlaması durumunda TRUE olarak ilgili değerin koşu sağlamasını sağlar. bookstore veritabanında yapmış olduğumuz aşağıdaki sorguyu inceleyelim.




//SELECT first_name, last_name FROM author
//WHERE id = ANY
//(
//  SELECT id
//  FROM book
//  WHERE title = 'Abe Lincoln in Illinois' OR title = 'Saving Shiloh'
//Yukarıda görmüş olduğunuz gibi alt sorgudan gelebilecek potansiye iki id değeri var, bu id değerinin her ikisi de birbirinden bağımsız
//olarak ana sorgudaki id sütununda bulunan değerler ile eşleştiği için sorgu sonucunda oluşan sana tabloda id değeri 4 ve 5 olan yazarlara ait first_name ve last_name değerlerini göreceğiz.



ALL Operatörü
//Alt sorgudan gelen tüm değerlerin koşulu sağlaması durumunda TRUE olarak döner.
//bookstore veritabanındaki yine aynı sorguyu inceleyelim


//SELECT first_name, last_name FROM author
//WHERE id = ALL
//(
//  SELECT id
//  FROM book
//  WHERE title = 'Abe Lincoln in Illinois' OR title = 'Saving Shiloh'
//)
//Burada ne söylemiştik alt sorgu tarafından 4 ve 5 id leri gelecek burada eştlik olduğu için aynı anda 4 ve 5 in bu şulu sağlaması olanaksız olduğu için herhangi bir değer dönülmeyecektir.




Alt Sorgular ve JOIN Kullanımı
//Altsorgular ve JOIN kavramları birlikte çok sık kullanılırlar. Aşağıdaki iki senaryoda bu iki yapıyı birlikte kullanacağız.


//İlk senaryomuz: bookstore veri tabanında kitap sayfası sayısı ortalama kitap sayfası sayısından fazla olan kitapların isimlerini, bu kitapların yazarlarına ait isim ve soyisim bilgileriyle birlikte sıralayınız.

//SELECT author.first_name, author.last_name, book.title FROM author
//INNER JOIN book ON book.author_id = author.id
//WHERE page_number >
//(
//  SELECT AVG(page_number) FROM book
//);



//Yukarıdaki sorgumuzda kitaplara ait yazar bilgilerini JOIN kullanarak elde ediyoruz. Ortalama sayfa sayısını da alt sorgudan getiriyoruz.

//İkinci senaryomuz: dvdrental veritabanında en uzun filmlerin isimlerini aktör isim ve soyisimleriyle birlikte sıralayalım.
//SELECT actor.first_name, actor.last_name, film.title FROM actor
//JOIN film_actor ON film_actor.actor_id = actor.actor_id
//JOIN film ON film.film_id = film_actor.film_id
//WHERE film.length =
//(
//  SELECT MAX(length)  FROM film
//)

//Burada da görmüş olduğumuz gibi film lerin aktör bilgilerini ikili JOIN yapısı kullanarak elde ediyoruz. En uzun film süresini de alt sorgudan getiriyoruz.



























