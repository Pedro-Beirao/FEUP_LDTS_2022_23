package jet.set.billy.controller.game;

import jet.set.billy.Room;

public class WorldController
{
    public WorldController(Room room)
    {
        current_room = room;
    }

    public void set_room(Room nroom)
    {
        current_room = nroom;
    }

    public void change_room(Player player, Room room) throws Exception
    {
        if (player.get_position_x() < 0)
        {
            String room_name = rooms.get(room.get_coord1()).get(room.get_coord2() - 1);
            String room_string = Files.readString(Paths.get(getClass().getClassLoader().getResource("rooms/"+room_name+".txt").toURI()));
            room_string = room_string.replaceAll("\r", "");
            current_room = new Room(room_string, room.get_coord1(), room.get_coord2() - 1, room_name);

            player.set_position_x(237);
            player.set_safe_position_x(player.get_position_x());
            player.set_safe_position_y(player.get_position_y());
        }
        else if (player.get_position_x() > 240)
        {
            String room_name = rooms.get(room.get_coord1()).get(room.get_coord2() + 1);
            String room_string = Files.readString(Paths.get(getClass().getClassLoader().getResource("rooms/"+room_name+".txt").toURI()));
            room_string = room_string.replaceAll("\r", "");
            current_room = new Room(room_string, room.get_coord1(), room.get_coord2() + 1, room_name);
            
            player.set_position_x(3);
            player.set_safe_position_x(player.get_position_x());
            player.set_safe_position_y(player.get_position_y());
        }
        else if (player.get_position_y() > 115)
        {
            String room_name = rooms.get(room.get_coord1() + 1).get(room.get_coord2());
            String room_string = Files.readString(Paths.get(getClass().getClassLoader().getResource("rooms/"+room_name+".txt").toURI()));
            room_string = room_string.replaceAll("\r", "");
            current_room = new Room(room_string, room.get_coord1() + 1, room.get_coord2(), room_name);
            
            player.set_position_y(-5);
            player.set_safe_position_x(player.get_position_x());
            player.set_safe_position_y(player.get_position_y());
        }
        else if (player.get_position_y() < -10)
        {
            String room_name = rooms.get(room.get_coord1() - 1).get(room.get_coord2());
            String room_string = Files.readString(Paths.get(getClass().getClassLoader().getResource("rooms/"+room_name+".txt").toURI()));
            room_string = room_string.replaceAll("\r", "");
            current_room = new Room(room_string, room.get_coord1() - 1, room.get_coord2(), room_name);
            
            player.set_position_y(107);
            player.set_safe_position_x(player.get_position_x());
            player.set_safe_position_y(player.get_position_y());
        }
    }   
}