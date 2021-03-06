USE [TEST_HIBERNATE]
GO
INSERT [dbo].[ACCOUNT] ([ID], [IMAGE], [FULLNAME], [PASSWORD], [USERNAME]) VALUES (N'U1', N'https://i.pinimg.com/474x/ca/1f/a9/ca1fa911867a29d411f17717f50069b4.jpg', N'Hitachi Kaka', N'1', N'admin')
INSERT [dbo].[ACCOUNT] ([ID], [IMAGE], [FULLNAME], [PASSWORD], [USERNAME]) VALUES (N'U2', N'https://i.pinimg.com/474x/3e/93/d3/3e93d3dcf5cedf7f8d20c0b3a7690983.jpg', N'Lakasu Shisi', N'1', N'user')
INSERT [dbo].[ACCOUNT] ([ID], [IMAGE], [FULLNAME], [PASSWORD], [USERNAME]) VALUES (N'U3', N'https://a.wattpad.com/useravatar/Seui_Shun.256.676330.jpg', N'Mataca Ushuzi', N'1', N'user1')
INSERT [dbo].[ACCOUNT] ([ID], [IMAGE], [FULLNAME], [PASSWORD], [USERNAME]) VALUES (N'U4', N'https://apprecs.org/ios/images/app-icons/256/f8/1168600824.jpg', N'Bamara Liyuka', N'1', N'user2')
INSERT [dbo].[ACCOUNT] ([ID], [IMAGE], [FULLNAME], [PASSWORD], [USERNAME]) VALUES (N'U5', N'https://img.wattpad.com/useravatar/Nhi_Miku_TRC.256.876373.jpg', N'Naruto Hitatry', N'1', N'manager')
INSERT [dbo].[ROLE] ([ID], [CODE], [NAME]) VALUES (N'R1', N'ADMIN', N'Quản trị')
INSERT [dbo].[ROLE] ([ID], [CODE], [NAME]) VALUES (N'R2', N'USER', N'Người dùng')
INSERT [dbo].[ROLE] ([ID], [CODE], [NAME]) VALUES (N'R3', N'MANAGER', N'Quản lý')
INSERT [dbo].[ACCOUNT_ROLE] ([ID_ACCOUNT], [ID_ROLE]) VALUES (N'U1', N'R1')
INSERT [dbo].[ACCOUNT_ROLE] ([ID_ACCOUNT], [ID_ROLE]) VALUES (N'U2', N'R2')
INSERT [dbo].[ACCOUNT_ROLE] ([ID_ACCOUNT], [ID_ROLE]) VALUES (N'U3', N'R2')
INSERT [dbo].[ACCOUNT_ROLE] ([ID_ACCOUNT], [ID_ROLE]) VALUES (N'U4', N'R2')
INSERT [dbo].[ACCOUNT_ROLE] ([ID_ACCOUNT], [ID_ROLE]) VALUES (N'U5', N'R3')
INSERT [dbo].[CATEGORY] ([ID], [IMAGE], [CODE], [NAME]) VALUES (N'C1', N'https://media.metrip.vn/upload_photos/g3/22762/s256x256/usr-photo-e1a2aab8df7a11e9b05598be9447cc1d.jpg', N'trai-cay', N'Trái cây')
INSERT [dbo].[CATEGORY] ([ID], [IMAGE], [CODE], [NAME]) VALUES (N'C2', N'https://lh3.googleusercontent.com/proxy/7t9aUfII2nfJVcuMYKlhC-W3f8mXxQwqaJr2l2wPFmCCQRMw4J_b1B2sg2rq665hFosxembL0tu-V0TjxhTdKQGy_TSC2qTG2ZlxPTjJ5lSoSOGWT_YtYE4zzDI2kftAY0G5D75OQhJQ9RSP2doiJkCGLEcGFQn4Xfu_nxkQZPCk7PPnHg', N'do-choi', N'Đồ chơi')
INSERT [dbo].[CATEGORY] ([ID], [IMAGE], [CODE], [NAME]) VALUES (N'C3', N'https://image.voso.vn/users/vosoimage/images/a974e0d98a4af3121ba5daaf415ec212?t%5B0%5D=maxSize%3Awidth%3D256%2Cheight%3D256&t%5B1%5D=compress%3Alevel%3D100&accessToken=fba58e9852545a03a09e6a578decdeb98e20feca08bdea3725fa8ddb79603c30', N'quan-ao', N'Quần áo')
INSERT [dbo].[CATEGORY] ([ID], [IMAGE], [CODE], [NAME]) VALUES (N'C4', N'https://static.roundme.com/upload/user/fca8b1af8631a0d030632046263b1b0a2a819848.jpg', N'dien-thoai', N'Điện thoại')
INSERT [dbo].[CATEGORY] ([ID], [IMAGE], [CODE], [NAME]) VALUES (N'C5', N'https://mlbwhmkwqybq.i.optimole.com/EyIsSdQ-Kx485Fux/w:256/h:256/q:90/rt:fill/g:ce/http://maisongnguyen.com/wp-content/uploads/2021/06/1_org.jpg', N'may-tinh', N'Máy tính')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P1', N'kiwi.jpg', N'Kiwi', 100, 25000, N'C1')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P2', N'chery.png', N'Chery', 120, 35000, N'C1')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P3', N'cam.jpg', N'Cam', 98, 15000, N'C1')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P4', N'chanhDay.jpg', N'Chanh dây', 120, 35000, N'C1')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P5', N'binhBat.jpg', N'Bình bát', 129, 9800, N'C1')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P6', N'vsmart.jpg', N'Smart Joy 3', 56, 3650000, N'C4')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P7', N'samsung.jpg', N'Samsung Galaxy C6', 89, 6780000, N'C4')
INSERT [dbo].[PRODUCT] ([ID], [IMAGE], [NAME], [QUANTITY], [PRICE], [ID_CATEGORY]) VALUES (N'P8', N'aoCuuHo.png', N'Áo khoác', 12, 89000, N'C3')
