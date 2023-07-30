# Hafta 6 Ödevi: Öğrenci Transkript


- Proje içerisinde 2 kategori oluşturdum, main ve util olarak.

- Util kategorisinde Grade ve GradeTest bulunmakta.
Grade Enum türünde, derslerden alınan notları hem String hem Numeric değerini tutuyor.
GradeTest classında ise bu Grade Enum'undaki değerleri forEach yapısıyla dönüp ekrana yazdırıyoruz.

- Main kategorisinde ise CourseGrade,Transcript ve GenerateTranscript classları bulunmakta.
CourseGrade classında kademeli constructor yapısı kullanıyoruz.Bu şekilde kullanıcıdan girilen değerler diğer constructorlara aktarılırken girilmeyen değerleri default value ile gönderiyoruz.
En sonda ise tüm parametreleri alan constructorda aldığımız değerleri setVariableName() metodlarını çağırarak işliyoruz.Burda direkt this kullanıp classtaki variable'a eşitlemememizin sebebi
bu gelen değerleri set metodu içinde kontrol edip istenen aralıkta olup olmamasını vs. kontrol edip doğru değilse default değer ile değiştirmek.
Bu classtaki set metodlarının hepsinde bizden istenene göre kontrol sağlanmakta.

- Transcript classında ise tek parametre(student Id) alan constructor bulunmakta.Bu constructorla nesne oluşturulduğu anda GPA 0.0 olarak atanmakta ve CourseGrade array listi oluşturulmakta.
addCourseTaken metodu parametre olarak CourseGrade nesnesi alıp eğer bu nesne null değilse listeye ekliyor, ve daha sonra calculateGpa metodunu çağırıp bu metodda Gpa'yı hesaplıyor ve bu değeri de
Gpa variable'ına atıyor.
Son olarak toString içinde printCourseGrades() metodunu çağırıyor ve bu metot içinde her bir CourseGrade için teker teker değerlerini yazıyor.

- GenerateTranscript classı 2 tane metod içeriyor.İlk metod takeInputFromUser, bu metod kullanıcıdan sırayla studentid,department,coursecode,coursecredit ve
coursegrade değerlerini alıyor ve bu değerlerle transcript ve coursegrade nesnelerini oluşturuyor, daha sonra transcript classındaki addcoursetaken metodunu çağırıp
coursegrade'i transcriptteki coursegrade listesine ekliyor.En sonda bu Transcript nesnesini dönüyor.
İkinci metod takeInputFromFile kullanıcıdan filename alıyor ve bu filenamei hw3/src/file altında arıyor.Eğer bulursa o file'dan en başta bulunan studentid değerini alıp
transcript nesnesi oluşturuyor, daha sonra diğer değerler ile coursegrade nesnesi oluşturuyor(kaç tane course varsa hepsini ekliyor, scanner.hasNextLine() ile check ediyor)
Metodun sonunda oluşturduğu transcript nesnesini dönüyor.

- Main classında kullanıcıdan değer girmesini istiyoruz, 1-Input ile transcript oluşturma, 2-File ile transcript oluşturma, 3-Çıkış.Kullanıcı girdiği değere göre
ilgili akışa yönleniyor.Eğer input seçtiyse değerleri girdikten sonra tekrar soruyoruz, çıkış yaparsa girdiği değerler ile oluşan Transcript nesnesi ekrana yazılıyor ya da tekrar input seçerse
yeniden takeInputFromUser akışına yönleniyor.Çıkışı seçene kadar bu döngü devam ediyor.Eğer file seçerse takeInputFromFile akışına gidiyor, dönen Transcript nesnesini
ekrana yazdırıyor ve program bitiyor.

## Ödev Olarak İletilen Doküman

![ödev page 1](/assets/Page1.png)
![ödev page 2](/assets/Page2.png)
![ödev page 3](/assets/Page3.png)
![ödev page 4](/assets/Page4.png)
