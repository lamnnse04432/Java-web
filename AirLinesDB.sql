create database AirLines

create table Users(
UserName varchar(50) not null primary key,
PassWord varchar(50) not null
)


create table Passengers(
Email varchar(200) not null primary key,
Password varchar(200) not null,
FirstName nvarchar(200) not null,
LastName nvarchar(200) not null,
Address nvarchar(200) not null,
PhoneNumber int not null,
Sex bit not null,
Age int not null,
CardNumber int not null
)

create table Cities(
CityID int not null primary key identity(1,1),
CityName nvarchar(100) not null 
)

create table Flight(
FlightID int not null primary key identity(1,1),
FromCity nvarchar(100) not null ,
ToCity nvarchar(100) not null ,
Duration float not null

)

create table Plane(
PlaneID varchar(100) not null primary key,
FlightID int not null foreign key references Flight(FlightID),
Fare float not null,
DepartureTime time,
DepartureDate date not null

)


create table Bookings(
BookingID int not null primary key identity(1,1),
Email varchar(200) not null foreign key references Passengers(Email),
PlaneID varchar(100) not null foreign key references Plane(PlaneID),
BookingDate date not null ,
BookingTime Time not null,
ReservationCode varchar(100) not null

)

insert into Passengers values ('lamnnse04432@fpt.edu.vn','81dc9bdb52d04dc20036dbd8313ed055','Lam','Nguyen','Ha Noi',01658024207,1,21,123456)
insert into Passengers values ('lamnn1996@fpt.edu.vn','81dc9bdb52d04dc20036dbd8313ed055','Nam','Nguyen','Ha Noi',01658024207,1,21,123456)

insert into Cities values ('Ha Noi')
insert into Cities values ('Hue')
insert into Cities values ('Da Nang')
insert into Cities values ('Hai Phong')
insert into Cities values ('Ho Chi Minh')



insert into Flight values ('Ha Noi','Hue',2)
insert into Flight values ('Ha Noi','Da Nang',4)
insert into Flight values ('Ha Noi','Hai Phong',1)
insert into Flight values ('Ha Noi','Ho Chi Minh',4.5)
insert into Flight values ('Hue','Ha Noi',2)
insert into Flight values ('Hue','Da Nang',1)
insert into Flight values ('Hue','Hai Phong',2.5)
insert into Flight values ('Hue','Ho Chi Minh',2)
insert into Flight values ('Hai Phong','Ha Noi',1.5)
insert into Flight values ('Hai Phong','Hue',2)
insert into Flight values ('Hai Phong','Da Nang',3)
insert into Flight values ('Hai Phong','Ho Chi Minh',5)
insert into Flight values ('Ho Chi Minh','Ha Noi',4)
insert into Flight values ('Ho Chi Minh','Hue',3.2)
insert into Flight values ('Ho Chi Minh','Da Nang',3)
insert into Flight values ('Ho Chi Minh','Hai Phong',2)


insert into Plane values ('BL01',1,20000,'10:20','2017-05-01')
insert into Plane values ('BL02',2,40000,'06:20','2017-05-20')
insert into Plane values ('BL03',3,25000,'08:20','2017-05-15')
insert into Plane values ('BL04',4,10000,'02:20','2017-09-01')
insert into Plane values ('BL05',5,62000,'10:30','2017-04-01')
insert into Plane values ('BL06',6,30000,'10:40','2017-01-02')
insert into Plane values ('BL07',7,10000,'09:20','2017-09-01')
insert into Plane values ('BL08',8,25000,'11:20','2017-01-01')
insert into Plane values ('BL09',9,80000,'10:10','2017-02-01')
insert into Plane values ('BL010',10,50000,'12:20','2017-03-04')
insert into Plane values ('BL011',11,26000,'03:10','2017-04-06')
insert into Plane values ('BL012',12,29000,'10:25','2017-05-04')
insert into Plane values ('BL013',13,80000,'10:20','2017-04-21')
insert into Plane values ('BL014',14,850000,'02:20','2017-07-26')
insert into Plane values ('BL015',15,20000,'10:20','2017-07-24')
insert into Plane values ('BL016',16,28000,'07:20','2017-08-29')


insert into Bookings values ('AB12','lamnnse04432@fpt.edu.vn','BL01')

select f.FlightID,f.FromCity,f.ToCity,f.Duration,p.PlaneID,p.DepartureDate,p.DepartureTime,p.Fare
from Flight f,Plane p
where  p.FlightID=f.FlightID and p.DepartureDate = '2017-05-01' and f.FromCity = 'Ha Noi' and f.ToCity = 'Hue'

select f.FlightID,f.FromCity,f.ToCity,f.Duration,p.PlaneID,p.DepartureDate,p.DepartureTime,p.Fare
from Flight f,Plane p
where  p.FlightID=f.FlightID and p.PlaneID = 'BL01'



select b.ReservationCode,b.Email,b.PlaneID,b.BookingDate,b.BookingTime,pg.FirstName,pg.LastName,p.FlightID,p.Fare,p.DepartureDate,p.DepartureTime,f.FromCity,f.ToCity,f.Duration
from Flight f,Plane p ,Bookings b,Passengers pg
where  p.FlightID=f.FlightID and p.PlaneID = b.PlaneID and b.Email=pg.Email and b.ReservationCode =''