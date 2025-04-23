using System;

namespace GestionReservas.Models
{
    public class Reservation
    {
        public string ProfileImagePath { get; set; } = "default.png";
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
            return $"{EventDate:dd/MM/yyyy} - {EventType} - {ContactName} ({NumberOfPeople} personas)";
        }
    }
}
