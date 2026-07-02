
**Sistema de Gestión de Salud**
 
**Descripción**
 
Sistema de gestión de salud desarrollado con Spring Boot y PostgreSQL. Administra tres tipos de perfiles: Pacientes, Nutriólogas y Personal Administrativo.
Permite gestionar citas, menús nutricionales, historial clínico, pagos y facturación.
 
→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→
 
**Tecnologías**
 
- Java          
- Spring Boot   
- Spring Data JPA  
- Hibernate    
- PostgreSQL      
- Lombok      
- Maven         
 
→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

**Arquitectura**
 
El proyecto sigue una arquitectura en capas basada en el patrón MVC extendido:

- Controller
- Service
- Mapper
- Entity
- Repository
- Database
- DTOs

→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→ 

**Decisiones Arquitectónicas**

- Patrón DTO: Los datos sensibles como contraseñas nunca se exponen. Se usan DTOs separados para entrada (Post), salida (Get) y actualización (Update).
- atrón Mapper: Clases estáticas responsables de convertir entre Entities y DTOs, manteniendo las capas desacopladas.
 
→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→ 

**Estado del Proyecto**
 
- Base de Datos        (Completado)
- Entidades JPA        (Completado)
- DTOs                 (Completado)
- Mappers              (Completado) 
- Servicios            (En progreso)
- Controladores        (Pendiente)
- Seguridad (JWT)      (Pendiente)
- Integración Stripe   (Pendiente)
 
→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→
 
**Módulos del Sistema**
 
- Pacientes
- Nutriólogas
- Personal Administrativo
- Citas
- Alimentos
- Menús Nutricionales
- Historial Clínico
- Pagos
- Facturas
- Horarios de Nutriólogas

