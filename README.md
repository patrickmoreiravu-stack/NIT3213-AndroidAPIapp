Android API App

Overview
This Android app demonstrates:
. API integration with vu-nit3213-api
. User authentication (Login Screen)
. Data display using RecyclerView (Dashboard Screen)
. Entity details view (Details Screen)
. Clean architecture principles with Hilt (DI), ViewModel and LiveData
. Unit testing of critical components

Features:
. Login Screen -> Authenticates using firstName + studentID (without s)
. Dashboard Screen -> Displays a list of entities from the API
. Details Screen -> Shows full information about a selected entity
. Dependency Injection -> Implemented with Hilt
. Unit Testing -> ViewModels tested with mocked repository
. Clean Code & Git -> Follows MVVM and proper commit history

API Endpoints:
Base URL: https://nit3213api.onrender.com/
. Login: /{location}/auth
   . Method: POST
   . Body: 
   {
   "username": "YourFirstName",
   "password": "12345678"
   }
. Dashboard: /dashboard/{keypass}

Teck Stack:
- Kotlin
- MVVM (Model-View-ViewModel)
- Hilt (Dagger)
- Retrofit + Moshi
- LiveData & ViewModel
- RecyclerView

Setup
1. Clone this repository:
   ```bash
   git clone https://github.com/YOUR-USERNAME/AndroidAPIApp.git
2. Open in Android Studio
3. Run on an emulator or a device
