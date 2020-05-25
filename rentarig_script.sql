DROP DATABASE IF EXISTS RENTARIG;
CREATE DATABASE RENTARIG;
USE RENTARIG;

DROP TABLE IF EXISTS address;
CREATE TABLE ADDRESS(

ADDRESS_ID INT AUTO_INCREMENT NOT NULL,
LINE_1 VARCHAR(255) NOT NULL,
LINE_2 VARCHAR(255) NOT NULL,
STATE VARCHAR(2) NOT NULL,
ZIP INT NOT NULL,
PRIMARY KEY(ADDRESS_ID)

);

DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
 
	USERNAME VARCHAR(30) NOT NULL,
    
    PASSWORD VARCHAR(30) NOT NULL,

    FIRST_NAME VARCHAR(30) NOT NULL,

    LAST_NAME VARCHAR(30) NOT NULL,

	ADDRESS VARCHAR(255) NOT NULL,

    EMAIL VARCHAR(255) NOT NULL,

    PHONE_NUMBER VARCHAR(255) NOT NULL,

    PRIMARY KEY(USERNAME)

    );
    
    DROP TABLE IF EXISTS products;
CREATE TABLE PRODUCTS(

   PRODUCT_ID VARCHAR(30) NOT NULL,
   
   PRODUCT_PRICE DECIMAL(6,2) NOT NULL,

   PRODUCT_NAME VARCHAR(255) NOT NULL,
   
   CATEGORY VARCHAR(255) NOT NULL,

   SHORT_DESC  TEXT NOT NULL,

   LONG_DESC MEDIUMTEXT NOT NULL,

   STOCK INT NOT NULL,

   PRIMARY KEY (PRODUCT_ID)

);

DROP TABLE IF EXISTS ORDERS;
CREATE TABLE ORDERS(

    ORDER_ID INT NOT NULL,

    USER_ID VARCHAR(30) NOT NULL REFERENCES USER(USERNAME),

    ORDER_DATE DATETIME NOT NULL,

    PRIMARY KEY(ORDER_ID)

    );
    
    DROP TABLE IF EXISTS ITEMS;
    CREATE TABLE ITEMS (
ITEM_ID INT NOT NULL AUTO_INCREMENT,
ORDER_ID INT NOT NULL REFERENCES ORDERS(ORDER_ID),
PRODUCT_ID INT NOT NULL REFERENCES PRODUCTS(PRODUCT_ID),
QUANTITY INT NOT NULL,
PRIMARY KEY(ITEM_ID)
);


INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_PRICE, PRODUCT_NAME, CATEGORY, SHORT_DESC, LONG_DESC, STOCK)  
VALUES (
'ROGSTRIXGL12', 
 60.00,
'ROG Strix GL12 Gaming Desktop',
'Gamingrigs,desktop',
'9th Gen 8-core Intel Core i7-9700F, NVIDIA GeForce RTX 2060 6 GB, 16 GB DDR4 RAM, 1 TB PCIe SSD, Windows 10 Home, Iron Grey, GL12CX-NS763',
'Rog Strix GL12 is engineered to quench gamers’ never-ending thirst for extreme gaming horsepower paired with striking, unconventional design. This Windows 10 Gaming desktop is powered by up to a factory-overclocked 9th generation Intel Core i7-9700k processor (Up to 5.0GHz full Octal-Core), with NVIDIA GeForce RTX 2080 graphics for boundless gaming experiences. Featuring ultra-fast SSD storage, The latest RAM, and Aura Sync RGB lighting, ROG Strix GL12 is ready for any gaming challenge you can throw at it! *The actual transfer speed of USB 3.0, 3.1 (Gen 1 and 2), and/or Type-C will vary depending on many factors including the processing speed of the host device, file attributes and other factors related to system configuration and your operating environment.',
20 
),

(
'ABSMAGEM',
50.00,
'ABS Mage M Gaming Desktop',
'Gamingrigs,desktop',
'Ryzen 5 3600 - Radeon RX 5700 XT - 16GB DDR4 3000MHz - 512GB SSD - Gaming Desktop PC',
'Take your home gaming and entertainment to the next level. Equipped with Ryzen 5 3600 (6 cores, 12 threads) processor and performance-class AMD Radeon RX 5700 XT-GPU based graphics, this desktop powers your rendering and editing workflows, as well as smooth gaming at up to 1440p in the hottest titles. The clean-designed mid tower is thermally-optimized with four 120mm RGB fans, and features an edge-to-edge tempered glass side panel to showcase the clean build bathed in brilliant RGB lighting. A gaming keyboard and a mouse are included for out-of-the-box use.',
20
),

(
'MSI_Trident_XPlus',
90.00,
'MSI Trident X Plus 9SD-461US Gaming Desktop',
'Gamingrigs,desktop',
'Intel Core i7-9700KF 3.60 GHz - 16 GB DDR4 1 TB SSD - NVIDIA GeForce RTX 2070 SUPER',
'Trident X Plus is the worlds smallest gaming desktop to incorporate Intel® 9th gen Core i9 CPU. Take a huge leap in performance with the 1st-ever eight-core i9-9900 K processor! Experience boosted gameplay and faster rendering by up to 50% performance',
18
),

(
'ASUS_VG245H',
10.00,
'ASUS VG245H 24" Gaming Monitor',
'Gamingrigs,monitors',
'1ms (GTG) Widescreen 2x HDMI Asus Eye Care with Ultra Low-Blue Light and Flicker-Free Console Gaming Monitor AMD FreeSync Built-in Speakers VESA Mountable Height and Pivot Adjustment',
'ASUS VG245H Full HD monitor is all about lag-free display of fast action—making it the perfect monitor for console gaming. The GameFast Input technology, ultra-fast 1ms response time, 75Hz refresh rate, AMD FreeSync technology and two low input lag HDMI ports work together to keep gameplay smooth and make your presses on the console almost instantly reflected on the screen. Intuition will take over even in the heat of action. Exclusive GamePlus offers four tactical tools such as crosshair and timer to make it easier to obliterate the enemies, while GameVisual provides six pre-set modes to optimize various types of content. Access to the tactical tool or pre-set mode you want only takes a press of a button. Its height-, swivel-, pivot-and tilt-adjustable design and eye-care technologies ensure your gaming monitor is always comfortable to view.',
20
),

(
'ACER_Z1_Z321QU',
20.00,
'Acer Predator Z1 Z321QU bmiphzx 31.5',
'Gamingrigs,monitors',
'WQHD 2560 x 1440 2K Resolution 165Hz 4ms HDMI DisplayPort NVIDIA G-Sync Technology USB 3.0 Hub Built-in Speakers LED Backlit LCD Curved Gaming Monitor',
'The Predator Z321QU is designed for ultimate gaming performance and style, the 16:9 aspect ratio and 31.5-inch curved screens transform your viewing experience by drawing you deep into the action. It also features NVIDIA® G-SYNC™ technology to eliminate screen tearing which provide gamers the epic gaming experience and help to secure the victory.',
20
),

(
'ASUS_XG32VQ',
20.00,
'ASUS ROG Strix XG32VQ 32',
'Gamingrigs,monitors',
'WQHD 2560 x 1440 2K Adaptive/FreeSync 144Hz 4ms Curved Gaming Monitors with Aura RGB Lighting Asus Eye Care with Ultra Low-Blue Light and Flicker-Free',
'ROG Strix XG32VQ offers the perfect balance between smooth gaming and brilliant image quality, so you can enjoy even the fastest-moving visuals in captivating detail. ROG Strix XG32VQ is a 32-inch QHD curved monitor with an astonishing 144Hz refresh rate and Adaptive-Sync (FreeSync™) for an extremely fluid gameplay without tearing and stuttering. It includes integrated ASUS Aura Sync lighting that allows for seamless synchronization with other Aura-enabled components and peripherals, adding personality to your gaming setup.',
20
),

(
'Roswell_Fusion_C40',
3.00,
'Rosewill Fusion C40 Gaming Keyboard and Mouse Combo',
'Gamingrigs,accessories',
'Dedicated Multimedia Keys, Mem-chanical Keyboard with Brilliant RGB LED Backlight with Precise Gaming Mouse, On-the-fly DPI Setting',
'Feel the keystrokes with instant satisfying typing experience. The FUSION C40 keys are built to combine the advantages of both mechanical and membrane keyboards, giving you a comfy feel with more the responsive tactile feedback and less the clinking sound while registering each keypress accurately and durably. It is also Cherry MX keycap compatible, so feel free to switch, customize and style up.',
20
),

(
'CM_Devastator_3',
3.00,
'Cooler Master Devastator 3 Gaming Combo',
'Gamingrigs,accessories',
'RGB Keyboard and Mouse Featuring Seven Different LED Color Options By Cooler Master',
'The Devastator 3 RGB Combo is the next generation of our popular gaming set. Featuring adjustable DPI up to 2400 and tactile keys for improved feedback, this is ideal for PC enthusiasts. And now with 7 different LED color options, you can customize your peripherals to match your hardware. 7 Colors to choose from. Ergonomic ultra low profile. 4 Levels of DPI. High-precision mouse wheel. Solid rubber side pads. Custom membrane design. Ultra durable laser. etched and grip coated keycaps. Anti-slide rubber pads on bottom. Dedicated multi-media keys.',
20
),

(
'CM_Storm_Devastator',
6.00,
'CM Storm Devastator',
'Gamingrigs,accessories',
'LED Gaming Keyboard and Mouse Combo Bundle (Blue Edition)',
'The Devastator combo consists of a gaming keyboard and mouse, both with full LED backlighting. An ergonomic, ultra low-profile design on both pieces ensures increased comfort for extended gaming sessions. Built to withstand everyday wear-and-tear, Devastator is a reliable and affordable bundle for casual and hardcore gamers alike.',
20
),

(
'MSI_9SF-240',
50.00,
'MSI GP Series GP65 Leopard 9SF-240 15.6',
'portable,gaminglaptops',
'144 Hz IPS Intel Core i7 9th Gen 9750H (2.60 GHz) NVIDIA GeForce RTX 2070 16 GB Memory 512 GB NVMe SSD Windows 10 Home 64-bit Gaming Laptop',
'NVIDIA GeForce RTX delivers the ultimate laptop gaming experience. These sleek, powerful gaming rigs are powered by the new NVIDIA Turing GPU architecture and the revolutionary RTX platform. RTX graphics bring together real-time ray tracing, artificial intelligence and programmable shading. The latest thin Bezel design not only offers immersive visual, but also fits a bigger display in a compact and small form factor. A perfect fit for your mobile experience.',
20
),

(
'ASUS_ROG_Zephyrus_S',
40.00,
'ASUS ROG Zephyrus S Ultra Slim Gaming PC Laptop, 15.6',
'portable,gaminglaptops',
'144 Hz IPS Type, Intel Core i7-8750H CPU, GeForce GTX 1070, 16 GB DDR4, 512 GB PCIe SSD, Military-Grade Metal Chassis, Windows 10 Home',
'Redefining ultra-slim gaming laptops with the original Zephyrus, ROG brings hardcore Windows 10 Pro gaming to an even thinner design framed by super-narrow bezels. ROG Zephyrus S uses innovative engineering to cool its GeForce RTXTM 2080 GPU and 9th Gen Intel Core i7 processor, so you can immerse yourself in its no-compromise 240Hz/3ms display',
20
),

(
'Acer_PH315',
45.00,
'Acer Predator Helios 300 PH315-52-71RT 15.6',
'portable,gaminglaptops',
'144 Hz IPS Intel Core i7 9th Gen 9750H (2.60 GHz) NVIDIA GeForce RTX 2060 16 GB Memory 512 GB SSD Windows 10 Pro 64-bit Gaming Laptop',
'Ready for battle and eager for a fight, the Helios 300 drops you into the game with everything you need. Only now we have armed it with NVIDIA GeForce RTX 2060 graphics, the latest Intel Core i7 Processor and our custom-engineered 4th Gen AeroBlade 3D Fan Technology. With the 144Hz IPS panel and 3ms Overdrive response time you can say farewell to blur and hello clear, crisp, high-octane gameplay. Online, keep control over your ping with Killer Control Center 2.0, Killer Ethernet E2500 + Killers Wireless AC 1550 components. With a pair of headphones on, experience virtual 3D audio with Waves NX Technology',
20
),

(
'Microsoft_Surface_JKX-00001',
60.00,
'Microsoft Laptop Surface Laptop JKX-00001',
'portable,thinandlight',
'Intel Core i7 7th Gen 7660U (2.50 GHz) 16 GB Memory 1 TB SSD Intel Iris Plus Graphics 640 13.5" Touchscreen Windows 10 Pro 64-Bit',
'Surface Laptop goes beyond the traditional laptop. Power through your day beautifully with industry-leading battery life and Intel Core processor. Enjoy a natural typing experience enhanced by a luxurious Alcantara fabric-covered keyboard. Navigate intuitively with a stunning touchscreen with 2256x1504 resolution. Backed by the best of Microsoft, including Windows and Office, the Surface Laptop also complements your style with rich colors options. Thin, light and powerful, it fits easily in your bag.',
20
),

(
'MacBook_Air',
60.00,
'Apple Laptop MacBook Air MJVE2LLA',
'portable,thinandlight',
'Intel Core i5 1.60 GHz 4 GB Memory 128 GB SSD Intel HD Graphics 5500 13.3" Mac OS X v10.10 Yosemite',
'macOS is the operating system that powers everything you do on a Mac. macOS Catalina brings new, dedicated apps for music, TV, and podcasts. Smart updates to the apps you use most. And Sidecar, which lets you use iPad as a second display. So you can take everything you do above and beyond.',
20
),

(
'Lenovo_ThinkPad',
50.00,
'Lenovo Laptop ThinkPad T480s (20L7002HUS)',
'portable,thinandlight',
'Intel Core i5 8th Gen 8250U (1.60 GHz) 8 GB Memory 256 GB SSD Intel UHD Graphics 620 14.0" Windows 10 Pro 64-Bit',
'Packed with robust performance, enhanced security features and easy maintenance, the Lenovo ThinkPad T480s is a lightweight, portable laptop built for your growing business. It offers all-day battery life and fast charging capability to let you stay productive anywhere you go. Abundant ports are also provided for convenient connectivity with various peripherals and devices.',
20
),

(
'Microsoft_Surface_Pro_4',
20.00,
'Microsoft Surface Pro 4',
'portable,tablets',
'12.3-Inch Touchscreen Tablet (4GB RAM, 128GB SSD, Intel Core i5)',
'Do not be fooled by its lithe body; ROG Zephyrus S has ample power for AAA games, VR experiences, and serious creative work. The six-core 9th Gen Intel Core i7 CPU delivers desktop-like performance, while the all-new NVIDIA GeForce RTX 2080 GPU enables photorealistic graphics thanks to real-time ray tracing technology and AI-enhanced image processing. ROG Boost ramps the GPU up to 1330MHz at 90W in turbo mode, with 8GB of GDDR6 VRAM clocked at 6151MHz, and both can be overclocked. An NVMe SSD up to 1TB offers speedy storage for your growing game library and professional portfolio.',
20
),

(
'Apple_iPad_Air',
15.00,
'Apple iPad Air MD788LL/A',
'portable,tablets',
'Apple A7 1 GB Memory 9.7" 2048 x 1536 Tablet (WiFi Only) iOS 7 Silver',
'You have to hold the iPad Air to believe it. It is just 7.5 millimeters thick and weighs just one pound. The stunning Retina display sits inside thinner bezels, so all you see is your content. And an incredible amount of power lies inside the sleek enclosure. You will do so much more with so much less.',
20
),

(
'Lenovo_yoga_tab_3',
10.00,
'Lenovo YOGA Tab 3 8 ZA090094US',
'portable,tablets',
'Qualcomm APQ8009 (1.30GHz) 2 GB Memory 16 GB eMMC 8.0" 1280 x 800 Tablet PC Android 5.1 (Lollipop) Black',
'Get lost in your favorite movies with immersive Dolby atmos sound, play your favorite games on a crisp HD screen and snap selfies with built-in gesture controls. All on a device weighing just over 1 pound for ultimate portability',
20
);

    