# 💳 MyCard - Credit Card Interface

<div align="center">
<!--   <img src="app_icon.png" alt="MyCard Icon" width="120"/> -->
  
  [![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
  [![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg)](https://kotlinlang.org)
  [![Material Design](https://img.shields.io/badge/UI-Material%20Design-blue.svg)](https://material.io)
  [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)
</div>

## 📱 About the Project

**MyCard** is an Android application that simulates a modern credit card registration interface, inspired by Nubank's clean and elegant design. The project was developed as a practical exercise to improve skills in native Android development with XML and Kotlin.

### ✨ Key Features

- 🎨 **Nubank-Inspired Design** - Modern and clean purple interface
- 💳 **Real-Time Visualization** - Virtual card that updates as you type
- ⌨️ **Automatic Formatting** - Card number formatted automatically (1234 5678 9101 1213)
- 📅 **Smart Date Input** - MM/YY format with date validation
- 🔒 **Robust Validations** - Real-time data verification
- 🏦 **Brand Detection** - Automatically identifies Visa, Mastercard, and Amex
- 📱 **Responsive Interface** - Adaptable to different screen sizes

## 🖼️ Screenshots

<div align="center">
  <img src="https://github.com/user-attachments/assets/34b22520-4f9f-4821-bbff-e4fda52f09b2" alt="App Screen" width="300"/>
  <p><em>Main application interface</em></p>
</div>

## 🚀 Features

### 💳 Interactive Virtual Card
- **Golden chip** realistic with details
- **Magnetic stripe** with gradient
- **Masked number** that reveals as you type
- **Cardholder name** in real time
- **Expiry date** synchronized
- **Brand logo** automatically detected

### 🔧 Smart Formatting
- **Card number**: Automatic spacing every 4 digits
- **Expiry date**: Automatic slash (/) insertion
- **Name**: Automatic conversion to uppercase
- **CVV**: 3-4 digit limitation

### ✅ Implemented Validations

| Field | Validation | Description |
|-------|-----------|-------------|
| **Number** | 16 mandatory digits | Verifies if it has exactly 16 numbers |
| **Name** | Minimum 3 characters | Cardholder name must have at least 3 letters |
| **Date** | Valid MM/YY | Month between 01-12 and year not before current |
| **CVV** | 3-4 digits | Valid security code |

## 🛠️ Technologies Used

- **[Kotlin](https://kotlinlang.org/)** - Main language
- **[Android SDK](https://developer.android.com)** - Native framework
- **[Material Design Components](https://material.io/develop/android)** - UI components
- **[ConstraintLayout](https://developer.android.com/training/constraint-layout)** - Responsive layout
- **[CardView](https://developer.android.com/guide/topics/ui/layout/cardview)** - Cards with elevation
- **XML Layouts** - Traditional declarative interface

## 📋 Prerequisites

- **Android Studio** 4.0+
- **Android SDK** API 21 (Android 5.0) or higher
- **Kotlin** 1.5+
- **Gradle** 7.0+

## ⚡ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/your-username/mycard.git
cd mycard
```

### 2. Open in Android Studio
- Open **Android Studio**
- Select **"Open an existing project"**
- Navigate to the cloned folder and select it

### 3. Sync dependencies
```kotlin
// build.gradle.kts (Module: app)
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
```

### 4. Run the project
- Connect an Android device or start an emulator
- Click **"Run"** or press `Shift + F10`

## 📁 Project Structure

```
app/src/main/
├── java/com/example/mycard/
│   └── MainActivity.kt           # Main logic and validations
├── res/
│   ├── layout/
│   │   └── activity_main.xml     # Main layout
│   ├── drawable/
│   │   ├── card_gradient.xml     # Card gradient
│   │   ├── card_chip.xml         # Golden chip
│   │   ├── ic_credit_card.xml    # Card icon
│   │   ├── ic_launcher_background.xml
│   │   ├── ic_launcher_foreground.xml
│   │   └── ic_launcher_monochrome.xml
│   └── values/
│       ├── colors.xml            # Color palette
│       ├── strings.xml           # App texts
│       └── themes.xml            # Custom themes
```

## 🎨 Color Palette

```xml
<!-- Inspired by Nubank -->
<color name="nubank_purple">#8A05BE</color>
<color name="nubank_light">#9D4EDD</color>
<color name="nubank_dark">#560BAD</color>
<color name="card_gold">#FFD700</color>
<color name="white">#FFFFFF</color>
```

## 🧪 Tested Features

- ✅ Automatic card number formatting
- ✅ Expiry date validation
- ✅ Card brand detection
- ✅ Real-time visual card updating
- ✅ Form validations
- ✅ Responsive interface
- ✅ Compatibility with different screen sizes

## 🔜 Future Improvements

- [ ] Transition animations
- [ ] Support for more card brands
- [ ] Dark/light mode
- [ ] Local card storage
- [ ] Camera card scanner
- [ ] Unit and instrumental tests
- [ ] Internationalization (i18n)

## 🤝 How to Contribute

1. **Fork** the project
2. Create a **branch** for your feature (`git checkout -b feature/new-feature`)
3. **Commit** your changes (`git commit -m 'Add new feature'`)
4. **Push** to the branch (`git push origin feature/new-feature`)
5. Open a **Pull Request**

## 📄 License

This project is under the **MIT** license. See the [LICENSE](LICENSE) file for more details.

---

<div align="center">
  <p>⭐ If this project was useful to you, leave a star!</p>
  <p>💜 Made with lots of love and coffee ☕</p>
</div>

---

<details>
<summary>🇧🇷 Versão em Português</summary>

# 💳 MyCard - Interface de Cartão de Crédito

<div align="center">
<!--   <img src="app_icon.png" alt="MyCard Icon" width="120"/> -->
  
  [![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
  [![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg)](https://kotlinlang.org)
  [![Material Design](https://img.shields.io/badge/UI-Material%20Design-blue.svg)](https://material.io)
  [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)
</div>

## 📱 Sobre o Projeto

**MyCard** é um aplicativo Android que simula uma interface moderna para cadastro de cartão de crédito, inspirada no design clean e elegante do Nubank. O projeto foi desenvolvido como exercício prático para aprimorar habilidades em desenvolvimento Android nativo com XML e Kotlin.

### ✨ Características Principais

- 🎨 **Design Inspirado no Nubank** - Interface roxa moderna e clean
- 💳 **Visualização em Tempo Real** - Cartão virtual que atualiza conforme você digita
- ⌨️ **Formatação Automática** - Número do cartão formatado automaticamente (1234 5678 9101 1213)
- 📅 **Data Inteligente** - Formato MM/AA com validação de data
- 🔒 **Validações Robustas** - Verificações em tempo real dos dados
- 🏦 **Detecção de Bandeira** - Identifica automaticamente Visa, Mastercard e Amex
- 📱 **Interface Responsiva** - Adaptável a diferentes tamanhos de tela

## 🖼️ Screenshots

<div align="center">
  <img src="https://github.com/user-attachments/assets/34b22520-4f9f-4821-bbff-e4fda52f09b2" alt="Tela do App" width="300"/>
  <p><em>Interface principal do aplicativo</em></p>
</div>

## 🚀 Funcionalidades

### 💳 Cartão Virtual Interativo
- **Chip dourado** realista com detalhes
- **Faixa magnética** com gradiente
- **Número mascarado** que revela conforme digitação
- **Nome do titular** em tempo real
- **Data de validade** sincronizada
- **Logo da bandeira** detectada automaticamente

### 🔧 Formatação Inteligente
- **Número do cartão**: Espaçamento automático a cada 4 dígitos
- **Data de validade**: Inserção automática da barra (/)
- **Nome**: Conversão automática para maiúsculas
- **CVV**: Limitação de 3-4 dígitos

### ✅ Validações Implementadas

| Campo | Validação | Descrição |
|-------|-----------|-----------|
| **Número** | 16 dígitos obrigatórios | Verifica se possui exatamente 16 números |
| **Nome** | Mínimo 3 caracteres | Nome do titular deve ter pelo menos 3 letras |
| **Data** | MM/AA válida | Mês entre 01-12 e ano não anterior ao atual |
| **CVV** | 3-4 dígitos | Código de segurança válido |

## 🛠️ Tecnologias Utilizadas

- **[Kotlin](https://kotlinlang.org/)** - Linguagem principal
- **[Android SDK](https://developer.android.com)** - Framework nativo
- **[Material Design Components](https://material.io/develop/android)** - Componentes de UI
- **[ConstraintLayout](https://developer.android.com/training/constraint-layout)** - Layout responsivo
- **[CardView](https://developer.android.com/guide/topics/ui/layout/cardview)** - Cartões com elevação
- **XML Layouts** - Interface declarativa tradicional

## 📋 Pré-requisitos

- **Android Studio** 4.0+
- **Android SDK** API 21 (Android 5.0) ou superior
- **Kotlin** 1.5+
- **Gradle** 7.0+

## ⚡ Como Executar

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/mycard.git
cd mycard
```

### 2. Abra no Android Studio
- Abra o **Android Studio**
- Selecione **"Open an existing project"**
- Navegue até a pasta clonada e selecione

### 3. Sincronize as dependências
```kotlin
// build.gradle.kts (Module: app)
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
```

### 4. Execute o projeto
- Conecte um dispositivo Android ou inicie um emulador
- Clique em **"Run"** ou pressione `Shift + F10`

## 📁 Estrutura do Projeto

```
app/src/main/
├── java/com/example/mycard/
│   └── MainActivity.kt           # Lógica principal e validações
├── res/
│   ├── layout/
│   │   └── activity_main.xml     # Layout principal
│   ├── drawable/
│   │   ├── card_gradient.xml     # Gradiente do cartão
│   │   ├── card_chip.xml         # Chip dourado
│   │   ├── ic_credit_card.xml    # Ícone do cartão
│   │   ├── ic_launcher_background.xml
│   │   ├── ic_launcher_foreground.xml
│   │   └── ic_launcher_monochrome.xml
│   └── values/
│       ├── colors.xml            # Paleta de cores
│       ├── strings.xml           # Textos do app
│       └── themes.xml            # Temas personalizados
```

## 🎨 Paleta de Cores

```xml
<!-- Inspirada no Nubank -->
<color name="nubank_purple">#8A05BE</color>
<color name="nubank_light">#9D4EDD</color>
<color name="nubank_dark">#560BAD</color>
<color name="card_gold">#FFD700</color>
<color name="white">#FFFFFF</color>
```

## 🧪 Funcionalidades Testadas

- ✅ Formatação automática do número do cartão
- ✅ Validação de data de validade
- ✅ Detecção de bandeira do cartão
- ✅ Atualização em tempo real do cartão visual
- ✅ Validações de formulário
- ✅ Interface responsiva
- ✅ Compatibilidade com diferentes tamanhos de tela

## 🔜 Melhorias Futuras

- [ ] Animações de transição
- [ ] Suporte para mais bandeiras de cartão
- [ ] Modo escuro/claro
- [ ] Salvamento local dos cartões
- [ ] Scanner de cartão com câmera
- [ ] Testes unitários e instrumentais
- [ ] Internacionalização (i18n)

## 🤝 Como Contribuir

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. **Push** para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um **Pull Request**

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">
  <p>⭐ Se este projeto foi útil para você, deixe uma estrela!</p>
  <p>💜 Feito com muito carinho e café ☕</p>
</div>

</details>
