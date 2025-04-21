using System;

namespace GestionReservas.Models
{
    public class Reservation
    {
        public string ContactName { get; set; }
        public string Phone { get; set; }
        public DateTime EventDate { get; set; }
        public string EventType { get; set; }
        public int NumberOfPeople { get; set; }
        public string FoodType { get; set; }
        public int Days { get; set; }
        public bool RequiresRooms { get; set; }

        public override string ToString()
        {
            return $"{ContactName} ({Phone}) - {EventType} el {EventDate.ToShortDateString()} para {NumberOfPeople} personas. Cocina: {FoodType}. Jornadas: {Days}, Habitaciones: {(RequiresRooms ? "Sí" : "No")}";
        }
    }
}
