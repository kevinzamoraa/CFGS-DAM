<<<<<<< HEAD
from odoo import models, fields

class User(models.Model):
    _name = 'gestion.usuario'
    _description = 'Usuario personalizado'

    nombre = fields.Char(string='Nombre', required=True)
    email = fields.Char(string='Correo Electrónico', required=True)
    idioma = fields.Selection([
        ('es_ES', 'Español'),
        ('en_US', 'Inglés'),
        ('fr_FR', 'Francés')
    ], string='Idioma', default='es_ES')
    zona_horaria = fields.Selection([
        ('Europe/Madrid', 'Madrid'),
        ('UTC', 'UTC'),
        ('America/Mexico_City', 'Ciudad de México')
    ], string='Zona Horaria', default='Europe/Madrid')
=======
from odoo import models, fields

class User(models.Model):
    _name = 'gestion.usuario'
    _description = 'Usuario personalizado'

    nombre = fields.Char(string='Nombre', required=True)
    email = fields.Char(string='Correo Electrónico', required=True)
    idioma = fields.Selection([
        ('es_ES', 'Español'),
        ('en_US', 'Inglés'),
        ('fr_FR', 'Francés')
    ], string='Idioma', default='es_ES')
    zona_horaria = fields.Selection([
        ('Europe/Madrid', 'Madrid'),
        ('UTC', 'UTC'),
        ('America/Mexico_City', 'Ciudad de México')
    ], string='Zona Horaria', default='Europe/Madrid')
>>>>>>> fc71c9d72898a25225fc78625a06e724eda4e53c
