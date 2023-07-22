# Hafta 6 Ödevi: Öğrenci Transkript


- Proje içerisinde 2 kategori oluşturdum, main ve util olarak.

- Util kategorisinde Grade ve GradeTest bulunmakta.
Grade Enum türünde, derslerden alınan notları hem String hem Numeric değerini tutuyor.
GradeTest classında ise bu Grade Enum'undaki değerleri forEach yapısıyla dönüp ekrana yazdırıyoruz.

- Main kategorisinde ise CourseGrade ve Transcript classları bulunmakta.
CourseGrade classında kademeli constructor yapısı kullanıyoruz.Bu şekilde kullanıcıdan girilen değerler diğer constructorlara aktarılırken girilmeyen değerleri default value ile gönderiyoruz.
En sonda ise tüm parametreleri alan constructorda aldığımız değerleri setVariableName() metodlarını çağırarak işliyoruz.Burda direkt this kullanıp classtaki variable'a eşitlemememizin sebebi
bu gelen değerleri set metodu içinde kontrol edip istenen aralıkta olup olmamasını vs. kontrol edip doğru değilse default değer ile değiştirmek.
Bu classtaki set metodlarının hepsinde bizden istenene göre kontrol sağlanmakta.

- Transcript classında ise tek parametre(student Id) alan constructor bulunmakta.Bu constructorla nesne oluşturulduğu anda GPA 0.0 olarak atanmakta ve CourseGrade array listi oluşturulmakta.
addCourseTaken metodu parametre olarak CourseGrade nesnesi alıp eğer bu nesne null değilse listeye ekliyor, ve daha sonra calculateGpa metodunu çağırıp bu metodda Gpa'yı hesaplıyor ve bu değeri de
Gpa variable'ına atıyor.
Son olarak toString içinde printCourseGrades() metodunu çağırıyor ve bu metot içinde her bir CourseGrade için teker teker değerlerini yazıyor.

- Main classında ise tüm bu yaptığımız işlemleri test etmek için bir transcript nesnesi oluşturuyoruz.Daha sonra istediğimiz sayıda grade nesnesi oluşturarak bunları
transcript.addCourseTaken() metoduna parametre olarak veriyoruz.Daha sonra System.out.println(transcript); yapıp Transcript classındaki toString vasıtasıyla tüm
değerleri düzgün bir biçimde yazdırıyoruz.

## Ödev Olarak İletilen Doküman

![ödev page 1](/assets/Page1.png)
![ödev page 2](/assets/Page2.png)
![ödev page 3](/assets/Page3.png)