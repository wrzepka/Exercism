public static class TelemetryBuffer
{
    public static byte[] ToBuffer(long reading)
    {
        byte[] buffer = new byte[9];
        sbyte prefix;
        byte[] bytes;
        
        if (reading >= 4294967296)
        {
            prefix = -8;
            bytes = BitConverter.GetBytes(reading);
        }
        else if (reading >= 2147483648)
        {
            prefix = 4;
            bytes = BitConverter.GetBytes((uint)reading);
        }
        else if (reading >= 65536)
        {
            prefix = -4;
            bytes = BitConverter.GetBytes((int)reading);
        }
        else if (reading >= 0)
        {
            prefix = 2;
            bytes = BitConverter.GetBytes((ushort)reading);
        }
        else if (reading >= -32768)
        {
            prefix = -2;
            bytes = BitConverter.GetBytes((short)reading);
        }
        else if (reading >= -2147483648)
        {
            prefix = -4;
            bytes = BitConverter.GetBytes((int)reading);
        }
        else
        {
            prefix = -8;
            bytes = BitConverter.GetBytes(reading);
        }

        buffer[0] = (byte)prefix;
        Array.Copy(bytes, 0, buffer, 1, bytes.Length);
        
        return buffer;
    }

    public static long FromBuffer(byte[] buffer)
    {
        sbyte prefix = (sbyte)buffer[0];
        long output = 0;

        switch (prefix)
        {
            case 8:
            case -8:
                output = BitConverter.ToInt64(buffer, 1);
                break;
            case 4:
                output = BitConverter.ToUInt32(buffer, 1);
                break;
            case -4:
                output = BitConverter.ToInt32(buffer, 1);
                break;
            case 2:
                output = BitConverter.ToUInt16(buffer, 1);
                break;
            case -2:
                output = BitConverter.ToInt16(buffer, 1);
                break;
        }
        
        return output;
    }
}
