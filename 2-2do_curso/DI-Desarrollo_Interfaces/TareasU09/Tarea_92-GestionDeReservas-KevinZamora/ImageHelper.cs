using System.Drawing;
using System.Drawing.Drawing2D;
using System.Windows.Forms;

public static class ImageHelper
{
    public static GraphicsPath CreateCirclePath(Rectangle bounds)
    {
        GraphicsPath path = new GraphicsPath();
        path.AddEllipse(bounds);
        return path;
    }

    public static void MakeCircularPictureBox(PictureBox picBox)
    {
        picBox.Paint += (s, e) =>
        {
            using (GraphicsPath path = CreateCirclePath(new Rectangle(0, 0, picBox.Width, picBox.Height)))
            {
                picBox.Region = new Region(path);
            }
        };
    }
}
