# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---

## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder </br>

---

## ⚠️ Importante! ⚠️

☕ Use Java versión 10 o superior para compatibilidad.

🎮 El ejecutable se encuentra en la carpeta jar.

📝 Se recomienda usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica si lo usaras como practicar.

---

## Datos para acceder a la app:

- **User**: admin
- **Password**: admin

---

## 📝 Eclipse

### ¿Cómo importar mi proyecto a Eclipse?

1 - Una vez dentro del Editor al lado izquierdo, haz clic en el <em>Files</em> que está en el menú en la parte superior, elige la opción <em>Open Projects from File System</em>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173164237-1db32d79-2b35-433f-817c-ec3fa30899fc.png">
</p>

Luego haz click en <em>Directory</em> y ubica el directorio del proyecto "clonado" o "extraído" en tu computadora. Haz click en <em>Finish</em> para completar la importación.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173110215-f9451a5e-a9eb-4056-aec8-6eb3e3601e53.png">
</p>

2 - La segunda forma de importar es en <em>File</em> en la opción <em>Import</em>. O a través del <strong>Project Explorer</strong> haz clic en el campo vacío con el botón derecho del mouse y elijas la opción <strong>Import</strong>.

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173111357-2ec928ac-5a3d-4f7c-ba84-8906d84bfd08.png">
</p>

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/169431325-23a2e3cb-85a3-4298-8e60-64dfa58e2e6f.png">
</p>

Si te decides por el <strong>Import</strong>, se abrirá la ventana correspondiente. Haz clic en la opción <em>Existing Projects Into Workspace</em> y en el botón <em>Next</em>.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/169431890-27f40955-27d8-4b4d-82df-d3507f85de6c.png">
</p>

Luego haz clic en el botón <em>Browse</em> y busca el proyecto en el directorio local.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/169432246-a769555c-daf9-490e-a0c7-908f7e5de967.png">
</p>

## 📅 JCalendar

Tras realizar la importación a tu editor, es necesario instalar la librería <strong>JCalendar</strong>, de lo contrário, el proyecto presentará un error y no será posible abrir la ventana de <strong>Reservas</strong>. </br>

Para instalar, se necesita descargar el paquete a través de ese enlace:
🔹 [Link para el JCalendar](https://toedter.com/jcalendar/)

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/169592420-7ea798d4-b7d2-4fd6-a03c-75f0fbc2e4bc.png">
</p>

El siguiente paso es extraer los archivos a una carpeta e importar los archivos desde la carpeta <strong>lib</strong> a una carpeta local e importar los archivos a Eclipse.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167366-664a8876-a5c9-45d1-880d-650fbd6f8b07.png">     
</p>

Archivos de carpeta <strong>lib</strong>:

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173699122-00cc4055-2098-4bba-8d3b-3bd252013116.png">
</p>

Haz click con el botón derecho encima del proyecto ubicado en el <strong>Package Explorer</strong>, elijas la opción <em>Build Path</em> y <em>Configure Build Path</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173167991-44b111ca-c2d6-4d83-b225-33eb2657448f.png">
</p>

El proyecto tendrá un mensaje de error que indica que la ruta de la biblioteca no existe en tu computadora. Haz click en <em>Libraries</em>, luego en <em>Classpath</em> seleccione el archivo JCalendar, elije la opción <em>Remove</em> y <em>Apply and Close</em>.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173167817-ddbdedc5-c4a6-4f6d-bd86-f86a153d6b88.png">
</p>

Para importar el <strong>Jcalendar</strong> desde tu computadora, después de haber "extraído" los archivos de la descarga, pulsa en <em>ClassPath</em> y luego en <em>Add External JARS</em> agrega uno por uno o selecciona todos de una vez y haz click en <em>Apply and Close</em>.

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/169596029-a9fa21ef-8d90-45a6-8aa2-be2d911d4074.png">
</p>

Por lo tanto, el proyecto debe contener los siguientes archivos después de las importaciones:

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173695620-7a4893e9-b9a1-44d6-8b70-c94a85ea891e.png">
</p>

## 🚧 Proyecto

#### Al clonar o descargar el proyecto base y tener instalado el JCalendar, tendrás esta presentación al ejecutar el proyecto en Eclipse:

<p align="center" >
     <img width="700" heigth="700" src="https://user-images.githubusercontent.com/91544872/189419249-06b539da-7cf2-4d40-a711-618a5c872096.png">
</p>

### ⚠️ Descargué el proyecto pero los caracteres especiales no funcionan:

Si tu proyecto tiene errores como los de la imagen, siga los pasos a continuación:

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/91544872/189419556-20b67f67-003c-47ac-a0ae-02cf814a6ccb.png">
</p>

Ve a <em>Window</em> y haz clic en <em>Preferences</em>.

<p align="center" >
     <img width="200" heigth="200" src="https://user-images.githubusercontent.com/101413385/173693126-8e2fec8b-91b1-4007-bbc5-010bb454f440.png">
</p>

Luego haz clic en <em>General</em> y en <em>Workspace</em>. Si tu <em>Text File Enconding</em> no está con el <strong>Default (UTF-8)</strong>, haz clic en <em>Other</em>, y eliges la opción <strong>UTF-8</strong>, y finaliza haciendo clic <em>Apply and Close</em>.

<p align="center" >
     <img width="500" heigth="500" src="https://user-images.githubusercontent.com/101413385/173691963-1e3d966e-5162-4393-9232-d5d395d5440f.png">
</p>
