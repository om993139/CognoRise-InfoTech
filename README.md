# 🚀 Advanced Calculator App 

Welcome to the **Advanced Calculator App** — an elegant and modern calculator built using **Kotlin** and **Jetpack Compose**. This app goes beyond basic arithmetic by adding a customizable UI, haptic feedback, and a robust history feature that keeps track of your past calculations. It's designed for performance and delivers a beautiful, eye-catching gradient design.

<p align="center">
  <img src="assets/screenshot1.png" alt="Calculator Screenshot" width="300">
  <img src="assets/screenshot2.png" alt="Calculator Screenshot" width="300">
</p>

---

## 🌟 Key Features

### ✨ Basic Arithmetic Operations

Perform simple math with ease! The app supports:
- **Addition** (`+`)
- **Subtraction** (`-`)
- **Multiplication** (`*`)
- **Division** (`/`)

### 🧮 Complex Calculations

Solve more advanced equations that include:
- **Parentheses**: Group and prioritize operations like `(2 + 3) * 4`
- **Multiple Operations**: Combine multiple arithmetic operations in a single calculation.

### 🕒 History Feature

The app saves your past calculations so you can refer to them later! Navigate to the **History Screen** via the top-right menu to:
- View previous equations and results.
- **Clear history** when you need a fresh start.

### 🎨 Customizable UI

We’ve designed the UI to be sleek and modern:
- **Cool gradient backgrounds** for calculator buttons.
- A top app bar with a **3-dot menu** for easy access to extra features.
- Fully **responsive** for different screen sizes and orientations.

### 🌈 Gradient Design

The app includes visually stunning **gradient backgrounds**:
- Gradient effects are applied to both the buttons and the top app bar for a unique, modern look.
- The overall design is aimed at providing a beautiful and immersive user experience.

### 🧩 Error Handling

We’ve implemented robust error handling for user-friendly operation:
- Clear error messages for invalid operations.
- Prevention of multiple consecutive operators like `++` or `--` for a smoother calculation process.

### 🖱 Haptic Feedback

Feel every button press with **haptic feedback**:
- Light vibration is triggered on each button press, enhancing the interactive experience.
- The vibration is fine-tuned for **subtle feedback**, providing a more enjoyable experience.

### 📱 Responsive Layout

The app has been optimized for all screen sizes:
- **Adaptive UI** elements resize dynamically to fit phones, tablets, and other devices.
- Whether in portrait or landscape, the layout ensures a comfortable and functional experience.

---

## 🎨 Cool UI and Design Details

The UI of this calculator is one of its standout features. The buttons are arranged in a **grid layout** for an intuitive and user-friendly experience. The overall UI design makes use of Material Design principles, particularly **Material3 components** for a modern aesthetic.

The colors of the buttons are also thoughtfully chosen to represent different functionalities:
- **Number Buttons**: Light and neutral colors for ease of visibility.
- **Operator Buttons** (`+`, `-`, `*`, `/`): Bright and prominent colors (like orange or red) to stand out.
- **Utility Buttons** (`DEL`, `AC`, `=`): Contrasting colors for easy access.

---

## 💡 How It Works

This calculator is built using **Jetpack Compose**, which allows for a modern and declarative UI. The core structure of the app includes:
- **ViewModel**: Manages the UI-related data and business logic for calculations.
- **State Management**: Observes changes in inputs and results to dynamically update the UI.
- **LazyVerticalGrid**: Used for creating the button layout grid.

Arithmetic operations are evaluated using **Mozilla Rhino** (a JavaScript engine). It handles complex calculations involving parentheses and multiple operations. The results are dynamically updated after every input, giving you real-time feedback.

### TopAppBar and History Navigation

The app bar at the top includes:
- **Title**: Displays "Calculator."
- **3-dot menu**: Clicking this opens up additional options, including the **History**.

### History Screen

The **History Screen** is a separate page where past calculations are stored. You can:
- View each calculation in detail (both the equation and result).
- **Clear all history** when desired, ensuring a fresh start for future calculations.

---

## 🛠 Features Breakdown

### Light Haptic Feedback
Each button press provides light haptic feedback for improved user experience. The haptic feedback has been fine-tuned to be lighter and more subtle than typical vibrations.

### Top Bar and History Navigation
The **top bar** provides a clean and functional design. The **3-dot menu** on the right-hand side opens an options menu where you can choose **History**. Upon clicking "History," you are taken to the dedicated **History Screen** that lists all previous calculations. You can also **clear the history** from this screen.

### Animation Effects
The button presses come with smooth animations to provide a fluid and interactive feel:
- **Fade-in/fade-out effects** when switching between the main calculator and history screens.
- **Button press animations** add a subtle depth and realism to each interaction.

---

## 🌍 Download and Try It Out

You can try out the app by downloading the APK from the link below:

[**Download APK**](#)

---

## 🛠 Future Roadmap

We are continually working to improve the Advanced Calculator App! Here’s what we plan to add in the future:

### Scientific Calculator
Add support for advanced operations like:
- **Trigonometry**: Sine, Cosine, Tangent, etc.
- **Logarithms**: Logarithmic functions for more complex calculations.

### Editable History
Allow users to:
- Reuse past calculations by tapping on them.
- **Edit** past equations and re-calculate results.

### Custom Themes
We aim to introduce:
- **Dark Mode**: A sleek, battery-friendly dark theme.
- **Custom Themes**: Allow users to pick from different color schemes to match their style.

---

## 💻 How to Contribute

We love contributions! Here’s how you can help improve the app:

1. Fork the project.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

Feel free to open an issue or pull request with any bug fixes, improvements, or new features.

---

## 🙌 Acknowledgments

A huge thanks to:
- **Jetpack Compose** for making modern Android development a breeze.
- **Material3 Components** for providing a beautiful, customizable UI framework.
- The **Kotlin** language for its elegance and simplicity in writing Android apps.

---

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

