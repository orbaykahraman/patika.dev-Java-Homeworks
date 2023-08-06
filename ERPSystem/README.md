# Proje Adı

## ERP SYSTEM

**Allianz GelecegimAll programı kapsamında geliştirilmiştir.**



**Projemizde 5 tane model(entity) classı bulunmaktadır.**
- Bill(Fatura)
- Customer(Müşteri)
- Product(Ürün)
- OrderItem(Ürünü sepete ekleme)
- CustomerOrder(Sepet)
--------------------------------------

# Proje Hakkında

Bu classlar BaseEntity classını extend etmektedir.
BaseEntity classında id,creationDate,updateDate alanları bulunmaktadır.

Bu entitylerin her biri için ayrı ayrı Controller,Service,Repository,Dto bulunmaktadır.

Dtolar herhangi bir request sonucunda kullanıcıya direkt olarak Entity nesnesini dönmek yerine kullandığımız sınıflardır, burada gerekli görmediğimiz alanları yazmayarak responseda göstermemiş oluyoruz.

Controllerlar belirlediğimiz url’ler aracığıyla(request mapping and get,put,post mapping) request almamızı sağlayan ve bu requestleri ilgili service classının ilgili metoduna iletiyor.

Serviceler içerisinde bulunan metodlarda business kuralllarını işleyen, gerekli obje oluşturma, değerleri set etme gibi işlemleri yapan classlardır.Daha sonra repositoryi çağırıp istenilen işlemin yapılmasını sağlıyor.

Repositoryler db ile etkileşimde olup kolayca update,insert,select,delete işlemleri yapmamızı sağlıyor.Projede Jpa repository kullanılmış olup genellikle bu interface içinde gelen hazır metodlar kullanılmıştır.

**Projede kullanışlı olması sebebiyle PostgreSql tercih edildi.**

Hibernate aracılığıyla tüm tablo ve kolonlar uygulamanın başlangıcında otomatik olarak oluşturuluyor.

OrderStatus Enum’u sipariş durumunu takip edebilmek için oluşturuldu, içerisinde bulunan değerler,
Waiting(sipariş onaylanmadı,fatura oluşmadı)
Approved(sipariş onaylanıp fatura oluştuktan sonra geçilen durumdur)
Delivering(fatura oluştuktan sonra, ürünlerin kargoda olduğunu belirtir)
Cancelled(siparişin iptalini temsil eder)

Application Properties dosyasında database bağlantısı için gereken propertyler belirtilmiştir, ayrıca tax_rate değişkeni burada 0.20 olarak belirtildi.

TaxConfig classındaki taxRate variableı buradaki değeri okuyor, ve bu classta bulunan metodda parametre olarak price alıyor ve gelen price’a tax rate oranında ekleme yapıp dönüyor.

--------------------------------------------------------------------------
# Programın Genel Akışı
**Product eklenir.(istenilen sayıda)
Customer oluşturulur, yeni customer oluşturulduğunda o kullanıcı için customerorder da oluşturulur, her kullanıcının 1 tane sepeti vardır.
OrderItem ile hangi ürünü almak istiyorsak ürün idsini ve sayısını istekle göndeririz, ayrıca path içinde customerid yi de belirtmemiz gerekir.
Bu oluşturduğumuz orderItem customerorder içinde bulunan listeye atılır,
bu listeye yeni ekleme oldukça totalPrice değeri artar.
Daha sonra createBill customer id ile çağrılarak o kullanıcın customerorderi  ile
fatura oluşturulur, bu esnada TaxConfig classındaki metoda sepetteki ürünlerin toplam price değeri(customerorder-totalPrice) gönderilir ve vergi eklenmiş değer faturaya yansıtılır.**

--------------------------------------------
# Gereksinimler
- **Spring Boot**
- **PostgreSQL**
