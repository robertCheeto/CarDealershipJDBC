CREATE DATABASE IF NOT EXISTS car_dealership;
USE car_dealership;

CREATE TABLE dealerships (
    dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);

CREATE TABLE vehicles (
    VIN VARCHAR(17) PRIMARY KEY,
    year INT,
    make VARCHAR(50),
    model VARCHAR(50),
    vehicle_type VARCHAR(50),
    color VARCHAR(20),
    odometer INT,
    price DECIMAL(10, 2),
    SOLD BOOLEAN DEFAULT FALSE
);

CREATE TABLE inventory (
    dealership_id INT,
    VIN VARCHAR(17),
    PRIMARY KEY (dealership_id, VIN),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE sales_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    sale_date DATE,
    sale_price DECIMAL(10, 2),
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE lease_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    lease_start_date DATE,
    lease_end_date DATE,
    monthly_payment DECIMAL(10, 2),
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);


INSERT INTO dealerships (name, address, phone) VALUES
('Bit Shift Motors', '101 Binary Blvd', '555-0001'),
('The Git Garage', '404 Not Found St', '555-0404'),
('Stack Overflow Auto Sales', '500 Server St', '555-0500'),
('Recursion Motors', '777 Loop Lane', '555-0777'),
('Null Pointer Dealership', '999 Memory Dr', '555-0999');


INSERT INTO vehicles (VIN, year, make, model, vehicle_type, color, odometer, price, SOLD) VALUES
('JF1ZNAA19P8700001', 2023, 'Subaru', 'WRX', 'Sedan', 'Blue', 5000, 35999.99, FALSE),
('WPOAA2993SS620008', 2024, 'Porsche', '911 Carrera', 'Coupe', 'Silver', 2000, 115999.99, FALSE),
('1C4RJFAG5FC123456', 2015, 'Jeep', 'Wrangler Unlimited', 'SUV', 'Orange', 72000, 27999.99, FALSE),
('JF2SJADC5EH400002', 2014, 'Subaru', 'Outback', 'SUV', 'Green', 89000, 14999.99, FALSE),
('JM1BM1U76F1456789', 2015, 'Mazda', 'MX-5 Miata', 'Convertible', 'Red', 38000, 19999.99, FALSE),
('JN1AR5EF6FM300009', 2015, 'Nissan', '370Z', 'Coupe', 'Yellow', 52000, 24999.99, FALSE),
('1C4HJXEG8NW234567', 2022, 'Jeep', 'Grand Cherokee', 'SUV', 'Black', 18000, 42999.99, FALSE),
('4S3BMHB68B3000003', 2011, 'Subaru', 'Impreza', 'Sedan', 'Silver', 125000, 8999.99, TRUE),
('WAUFFAFL5DN234567', 2013, 'Audi', 'S4', 'Sedan', 'Black', 92000, 22999.99, FALSE),
('JF1ZCAC19N9700004', 2022, 'Subaru', 'BRZ', 'Coupe', 'Red', 12000, 29999.99, FALSE),
('5TDJZRFH8LS789012', 2020, 'Toyota', '4Runner', 'SUV', 'Silver', 48000, 38999.99, FALSE),
('WBA3B1C58EF400011', 2014, 'BMW', 'M3', 'Sedan', 'Blue', 62000, 36999.99, FALSE),
('JM3KFBCM5K0567890', 2019, 'Mazda', 'CX-5', 'SUV', 'Blue', 42000, 25999.99, FALSE),
('JTHBP5C27C5000010', 2012, 'Lexus', 'IS F', 'Sedan', 'Gray', 78000, 28999.99, TRUE),
('3VWD17AJ9EM012345', 2014, 'Volkswagen', 'GTI', 'Hatchback', 'Red', 68000, 16999.99, FALSE),
('JF2SJAWC8KH500005', 2019, 'Subaru', 'Crosstrek', 'SUV', 'Orange', 35000, 23999.99, FALSE),
('WDDHF8JB8CA456789', 2012, 'Mercedes-Benz', 'C63 AMG', 'Sedan', 'Silver', 85000, 29999.99, FALSE),
('1G1YY26E965000012', 2006, 'Chevrolet', 'Corvette Z06', 'Coupe', 'Red', 48000, 39999.99, FALSE),
('1C4PJMCB6HW345678', 2017, 'Jeep', 'Cherokee', 'SUV', 'Gray', 55000, 21999.99, TRUE),
('JTEBU5JR4K5890123', 2019, 'Toyota', 'GR Supra', 'Coupe', 'Yellow', 22000, 52999.99, TRUE),
('4S4BSAFC8L3000006', 2020, 'Subaru', 'Forester', 'SUV', 'White', 28000, 26999.99, TRUE),
('KMHHT6KD0NU678901', 2022, 'Hyundai', 'Elantra N', 'Sedan', 'Blue', 12000, 32999.99, FALSE),
('JF1VA1A66H9000007', 2017, 'Subaru', 'WRX STI', 'Sedan', 'Black', 45000, 32999.99, FALSE),
('WA1LNAFE7HD345678', 2017, 'Audi', 'Q5', 'SUV', 'White', 58000, 31999.99, TRUE),
('2C3CDXBG8KH600013', 2019, 'Dodge', 'Challenger R/T', 'Coupe', 'Black', 31000, 34999.99, FALSE),
('JM1ND2MA3N0678901', 2022, 'Mazda', '3 Turbo', 'Sedan', 'White', 15000, 28999.99, FALSE),
('KNDPM3AC7N7789012', 2022, 'Kia', 'Stinger GT', 'Sedan', 'Red', 18000, 39999.99, FALSE),
('WBADT43452G000014', 2002, 'BMW', 'M5', 'Sedan', 'Silver', 145000, 18999.99, FALSE),
('JTMZFREV8LJ901234', 2020, 'Toyota', 'RAV4', 'SUV', 'Green', 35000, 28999.99, FALSE),
('JN1AZ4EH2FM700015', 2015, 'Nissan', 'GT-R', 'Coupe', 'White', 38000, 74999.99, TRUE),
('WVWZZZ3CZPE123456', 2023, 'Volkswagen', 'Golf R', 'Hatchback', 'Blue', 8000, 44999.99, FALSE),
('WDD1J7DB5KF567890', 2019, 'Mercedes-Benz', 'E-Class', 'Sedan', 'Gray', 38000, 44999.99, FALSE),
('JN1AZ4EH6FM890123', 2015, 'Infiniti', 'Q50', 'Sedan', 'White', 62000, 24999.99, FALSE),
('YV4H60CF8R1901234', 2024, 'Volvo', 'XC60', 'SUV', 'Black', 5000, 51999.99, FALSE),
('KMHGH4JH8NU012345', 2022, 'Genesis', 'G70', 'Sedan', 'Gray', 14000, 41999.99, TRUE);


INSERT INTO inventory (dealership_id, VIN) VALUES
(1, 'JF1ZNAA19P8700001'),
(1, 'WPOAA2993SS620008'),
(1, 'JF1VA1A66H9000007'),
(1, '1C4HJXEG8NW234567'),
(1, 'WVWZZZ3CZPE123456'),
(1, 'YV4H60CF8R1901234'),
(1, 'KMHHT6KD0NU678901'),
(2, 'JF2SJADC5EH400002'),
(2, 'JN1AR5EF6FM300009'),
(2, 'WBA3B1C58EF400011'),
(2, 'WBADT43452G000014'),
(2, 'WAUFFAFL5DN234567'),
(2, 'JM1BM1U76F1456789'),
(2, 'JTMZFREV8LJ901234'),
(3, '4S3BMHB68B3000003'),
(3, 'JF1ZCAC19N9700004'),
(3, '1G1YY26E965000012'),
(3, '1C4RJFAG5FC123456'),
(3, 'JTEBU5JR4K5890123'),
(3, 'KNDPM3AC7N7789012'),
(3, 'WDD1J7DB5KF567890'),
(4, 'JF2SJAWC8KH500005'),
(4, 'JTHBP5C27C5000010'),
(4, '2C3CDXBG8KH600013'),
(4, '5TDJZRFH8LS789012'),
(4, 'JM3KFBCM5K0567890'),
(4, 'WA1LNAFE7HD345678'),
(4, '1C4PJMCB6HW345678'),
(5, '4S4BSAFC8L3000006'),
(5, 'JN1AZ4EH2FM700015'),
(5, 'WDDHF8JB8CA456789'),
(5, '3VWD17AJ9EM012345'),
(5, 'JM1ND2MA3N0678901'),
(5, 'JN1AZ4EH6FM890123'),
(5, 'KMHGH4JH8NU012345');

INSERT INTO sales_contracts (VIN, sale_date, sale_price, customer_name, customer_email) VALUES
('4S3BMHB68B3000003', '2024-10-15', 8999.99, 'Alice Johnson', 'alice.j@email.com'),
('4S4BSAFC8L3000006', '2024-11-02', 26999.99, 'Bob Smith', 'bob.smith@email.com'),
('JTHBP5C27C5000010', '2024-09-20', 28999.99, 'Carol Davis', 'carol.d@email.com'),
('JN1AZ4EH2FM700015', '2024-11-28', 74999.99, 'David Chen', 'david.chen@email.com'),
('1C4PJMCB6HW345678', '2024-10-05', 21999.99, 'Emily Rodriguez', 'emily.r@email.com'),
('JTEBU5JR4K5890123', '2024-11-15', 52999.99, 'Frank Thompson', 'frank.t@email.com'),
('WA1LNAFE7HD345678', '2024-09-12', 31999.99, 'Grace Park', 'grace.p@email.com'),
('KMHGH4JH8NU012345', '2024-11-22', 41999.99, 'Henry Liu', 'henry.l@email.com');

-- Insert data for lease_contracts (OPTIONAL)
INSERT INTO lease_contracts (VIN, lease_start_date, lease_end_date, monthly_payment, customer_name, customer_email) VALUES
('JF1ZNAA19P8700001', '2024-01-15', '2027-01-15', 499.99, 'Emma Wilson', 'emma.w@email.com'),
('JF2SJAWC8KH500005', '2024-03-01', '2027-03-01', 349.99, 'Frank Miller', 'frank.m@email.com'),
('2C3CDXBG8KH600013', '2024-06-10', '2027-06-10', 429.99, 'Grace Lee', 'grace.lee@email.com');
