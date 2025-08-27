📱 Wallpaper App

A simple and modern **Wallpaper Application** built using **Kotlin**, **Retrofit**, and the **Pexels API**.
This app allows users to **browse, search, download, and set wallpapers** directly from their phone.

---

✨ Features

🔍 **Search Wallpapers** – Search wallpapers by keywords using the Pexels API.
📂 **Browse Collection** – Default wallpaper feed (20 wallpapers per page).
⏭️ **Pagination** – Load more wallpapers with "Next Page" button.
📥 **Download Wallpaper** – Save wallpapers to your device.
🖼 **Set as Wallpaper** – Apply wallpaper directly from the app.
⚡ **Fast & Lightweight** – Uses Retrofit + Glide for smooth performance.

---

🛠️ Tech Stack

* **Language:** Kotlin
* **API:** [Pexels API](https://www.pexels.com/api/)
* **Networking:** Retrofit
* **Image Loading:** Glide
* **Architecture:** MVVM (recommended structure)
* **UI:** RecyclerView, CardView

---


## 🚀 Getting Started

### 1. Clone Repository

```bash
git clone https://github.com/sharmajay37/wallpaper-app.git
cd wallpaper-app
```

### 2. Add Your Pexels API Key

* Go to [Pexels API](https://www.pexels.com/api/) and create a free account.
* Copy your API key.
* Open `ApiService.kt` and replace with your API key:

```kotlin
private const val API_KEY = "YOUR_PEXELS_API_KEY"
```

### 3. Run the App

* Open the project in **Android Studio**.
* Sync Gradle.
* Run on emulator or physical device.

---

## 📦 Dependencies

```gradle
implementation "androidx.recyclerview:recyclerview:1.3.1"
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:converter-gson:2.9.0"
implementation "com.github.bumptech.glide:glide:4.16.0"
kapt "com.github.bumptech.glide:compiler:4.16.0"
```

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📜 License

This project is licensed under the **MIT License**.
