# PresupuestoTomasPG

Buenos días,
He entregado la tarear, pero no te había escrito el readme.

El proyecto que he creado es en modelo-vista-controlador, donde había dos vistas, una la entrada de los datos, y otra la salida.
He creado tres beans, una por cada funcionalidad de los formularios que se van presentando.
El bean edificio y  el bean contenido, además de tener los atributos de cada control del formulario, también tiene un atributo de resultado
para poderlo pasar a sesión y mostrar el resultado, además de una cadena que contiene, los atributos de los beans con las etiquetas html, para
mostrarla directamente(la idea era mostrar dos columnas con css y flex-box, pero no se que pasa con el netbeans que no lo pillaba, y me saca
dos bloques uno debajo de otro.
  Este proyecto, la transferencia de los datos entre páginas se hace a través de las sesiones, donde guardo los objetos beans y luego los muestra
  en la vista. 
  He utilizado el String builder para concatenar la  cadena que luego guardamos en el objeto bean, que luego muestro con el resultado final.
