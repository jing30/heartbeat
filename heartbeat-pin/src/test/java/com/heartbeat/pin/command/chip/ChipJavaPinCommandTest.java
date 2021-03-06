package com.heartbeat.pin.command.chip;

import com.heartbeat.common.board.OperatingSystem;
import com.heartbeat.pin.Pin;
import com.heartbeat.pin.command.PinCommandException;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder
public class ChipJavaPinCommandTest {
    private Pin getPin() throws PinCommandException {
        final Pin pin = new Pin("P1", Pin.Mode.IN, new ChipJavaPinCommand());
        return pin;
    }

    @Test
    public void testGetMode() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.getMode(getPin());
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    private void dealWithException(PinCommandException e) {
        e.printStackTrace();
        if (OperatingSystem.getType().equals(OperatingSystem.Type.MAC_OS))
            assert e.getMessage().contains("sudo:") || e.getMessage().contains("No such file or directory");
        else if (OperatingSystem.getType().equals(OperatingSystem.Type.LINUX))
            assert e.getMessage().contains("sudo:") || e.getMessage().contains("No such file or directory") || e.getMessage().contains("(Permission denied)");
        else if (OperatingSystem.getType().equals(OperatingSystem.Type.WINDOWS))
            assert e.getMessage().contains("'sudo' is not recognized as an internal or external command");
    }

    @Test
    public void testSetMode() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.setMode(getPin(), Pin.Mode.IN);
            assert true;
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    @Test
    public void testEnable() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.enable(getPin());
            assert true;
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    @Test
    public void testDisable() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.disable(getPin());
            assert true;
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    @Test
    public void testRead() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.read(getPin());
            assert true;
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    @Test
    public void testWrite() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            cmd.write(getPin(), false);
            assert true;
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }

    @Test
    public void testPath() throws Exception {
        try {
            ChipJavaPinCommand cmd = new ChipJavaPinCommand();
            assert cmd.path(getPin()).equals("/sys/class/gpio/gpioP1");
        } catch (PinCommandException e) {
            dealWithException(e);
        }
    }
}
