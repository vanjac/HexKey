# HexKey
This program is based on [HexASound](http://hexasound.com/), which is an iOS app
(not by me) that arranges music notes in a hexagonal grid. Since computer
keyboard keys are in a somewhat hexagonal arrangement, I was able to move all
controls to the keyboard. Although it is smaller, it is easier to feel the keys
by touch. A diagram is
[here](http://www.keyboard-layout-editor.com/##@_name=Hexkey%20Layout&author=Jacob%20van't%20Hoog%3B&@_c=%23BF3F3F%3B&=~%0A%60%0A%0A%0A%0A%0A%0A%0A%0AC%204&_c=%23BFBF3F%3B&=!%0A1%0A%0A%0A%0A%0A%0A%0A%0AD%204&_c=%233FBF3F%3B&=%2F@%0A2%0A%0A%0A%0A%0A%0A%0A%0AE%204&_c=%233FBFBF%3B&=%23%0A3%0A%0A%0A%0A%0A%0A%0A%0AF%23%204&_c=%233F3FBF%3B&=$%0A4%0A%0A%0A%0A%0A%0A%0A%0AG%23%204&_c=%23BF3FBF%3B&=%25%0A5%0A%0A%0A%0A%0A%0A%0A%0AA%23%204&_c=%23BF3F3F%3B&=%5E%0A6%0A%0A%0A%0A%0A%0A%0A%0AC%205&_c=%23BFBF3F%3B&=%2F&%0A7%0A%0A%0A%0A%0A%0A%0A%0AD%205&_c=%233FBF3F%3B&=*%0A8%0A%0A%0A%0A%0A%0A%0A%0AE%205&_c=%233FBFBF%3B&=(%0A9%0A%0A%0A%0A%0A%0A%0A%0AF%23%205&_c=%233F3FBF%3B&=)%0A0%0A%0A%0A%0A%0A%0A%0A%0AG%23%205&_c=%23BF3FBF%3B&=%2F_%0A-%0A%0A%0A%0A%0A%0A%0A%0AA%23%205&_c=%23BF3F3F%3B&=+%0A%2F=%0A%0A%0A%0A%0A%0A%0A%0AC%206&_c=%23BFBF3F&w:2%3B&=Backspace%0A%0A%0A%0A%0A%0A%0A%0A%0AD%206%3B&@_c=%23BF3F7F&g:true&w:1.5%3B&=Tab%0A%0A%0A%0A%0A%0A%0A%0A%0AB%203&_c=%23BF7F3F&g:false%3B&=Q%0A%0A%0A%0A%0A%0A%0A%0A%0AC%23%204&_c=%237FBF3F%3B&=W%0A%0A%0A%0A%0A%0A%0A%0A%0AD%23%204&_c=%233FBF7F%3B&=E%0A%0A%0A%0A%0A%0A%0A%0A%0AF%204&_c=%233F7FBF%3B&=R%0A%0A%0A%0A%0A%0A%0A%0A%0AG%204&_c=%237F3FBF%3B&=T%0A%0A%0A%0A%0A%0A%0A%0A%0AA%204&_c=%23BF3F7F%3B&=Y%0A%0A%0A%0A%0A%0A%0A%0A%0AB%204&_c=%23BF7F3F%3B&=U%0A%0A%0A%0A%0A%0A%0A%0A%0AC%23%205&_c=%237FBF3F%3B&=I%0A%0A%0A%0A%0A%0A%0A%0A%0AD%23%205&_c=%233FBF7F%3B&=O%0A%0A%0A%0A%0A%0A%0A%0A%0AF%205&_c=%233F7FBF%3B&=P%0A%0A%0A%0A%0A%0A%0A%0A%0AG%205&_c=%237F3FBF%3B&=%7B%0A%5B%0A%0A%0A%0A%0A%0A%0A%0AA%205&_c=%23BF3F7F%3B&=%7D%0A%5D%0A%0A%0A%0A%0A%0A%0A%0AB%205&_c=%23BF7F3F&w:1.5%3B&=%7C%0A%5C%0A%0A%0A%0A%0A%0A%0A%0AC%23%206%3B&@_c=%23BF3FBF&w:1.75%3B&=Caps%20Lock%0A%0A%0A%0A%0A%0A%0A%0A%0AA%23%203&_c=%23BF3F3F%3B&=A%0A%0A%0A%0A%0A%0A%0A%0A%0AC%204&_c=%23BFBF3F%3B&=S%0A%0A%0A%0A%0A%0A%0A%0A%0AD%204&_c=%233FBF3F%3B&=D%0A%0A%0A%0A%0A%0A%0A%0A%0AE%204&_c=%233FBFBF&n:true%3B&=F%0A%0A%0A%0A%0A%0A%0A%0A%0AF%23%204&_c=%233F3FBF%3B&=G%0A%0A%0A%0A%0A%0A%0A%0A%0AG%23%204&_c=%23BF3FBF%3B&=H%0A%0A%0A%0A%0A%0A%0A%0A%0AA%23%204&_c=%23BF3F3F&n:true%3B&=J%0A%0A%0A%0A%0A%0A%0A%0A%0AC%205&_c=%23BFBF3F%3B&=K%0A%0A%0A%0A%0A%0A%0A%0A%0AD%205&_c=%233FBF3F%3B&=L%0A%0A%0A%0A%0A%0A%0A%0A%0AE%205&_c=%233FBFBF%3B&=%2F:%0A%2F%3B%0A%0A%0A%0A%0A%0A%0A%0AF%23%205&_c=%233F3FBF%3B&=%22%0A'%0A%0A%0A%0A%0A%0A%0A%0AG%23%205&_c=%23BF3FBF&w:2.25%3B&=Enter%0A%0A%0A%0A%0A%0A%0A%0A%0AA%23%205%3B&@_c=%237F3FBF&w:2.25%3B&=Shift%0A%0A%0A%0A%0A%0A%0A%0A%0AA%203&_c=%23BF3F7F%3B&=Z%0A%0A%0A%0A%0A%0A%0A%0A%0AB%203&_c=%23BF7F3F%3B&=X%0A%0A%0A%0A%0A%0A%0A%0A%0AC%23%204&_c=%237FBF3F%3B&=C%0A%0A%0A%0A%0A%0A%0A%0A%0AD%23%204&_c=%233FBF7F%3B&=V%0A%0A%0A%0A%0A%0A%0A%0A%0AF%204&_c=%233F7FBF%3B&=B%0A%0A%0A%0A%0A%0A%0A%0A%0AG%204&_c=%237F3FBF%3B&=N%0A%0A%0A%0A%0A%0A%0A%0A%0AA%204&_c=%23BF3F7F%3B&=M%0A%0A%0A%0A%0A%0A%0A%0A%0AB%204&_c=%23BF7F3F%3B&=%3C%0A,%0A%0A%0A%0A%0A%0A%0A%0AC%23%205&_c=%237FBF3F%3B&=%3E%0A.%0A%0A%0A%0A%0A%0A%0A%0AD%23%205&_c=%233FBF7F%3B&=%3F%0A%2F%2F%0A%0A%0A%0A%0A%0A%0A%0AF%205&_c=%233F7FBF&w:2.75%3B&=Shift%0A%0A%0A%0A%0A%0A%0A%0A%0AG%205%3B&@_c=%233FBFBF&w:1.25%3B&=Ctrl%0A%0A%0A%0A%0A%0A%0A%0A%0AF%23%203&_c=%233F3FBF&g:true&w:1.25%3B&=Win%0A%0A%0A%0A%0A%0A%0A%0A%0AG%23%203&_c=%23BF3FBF&g:false&w:1.25%3B&=Alt%0A%0A%0A%0A%0A%0A%0A%0A%0AA%23%203&_c=%23cccccc&a:7&w:6.25%3B&=&_c=%23BF3F3F&a:4&w:1.25%3B&=Alt%0A%0A%0A%0A%0A%0A%0A%0A%0AC%205&_c=%23BFBF3F&g:true&w:1.25%3B&=Win%0A%0A%0A%0A%0A%0A%0A%0A%0AD%205&_c=%233FBF3F&g:false&w:1.25%3B&=Menu%0A%0A%0A%0A%0A%0A%0A%0A%0AE%205&_c=%233FBFBF&w:1.25%3B&=Ctrl%0A%0A%0A%0A%0A%0A%0A%0A%0AF%23%205).

HexKeyFrame is the main class. When you start the program it will search for all
MIDI output devices - this includes software synthesizers as well as actual
physical devices like MIDI keyboards. Using a real MIDI keyboard is highly
recommended, if possible. The lag created by software synthesizers is small, but
for some it can become very noticeable when you try to play music.

Once the program starts, a very small window will appear. That window doesn't do
anything but it does capture keyboard input, so it must be in the foreground. A 
link to the keyboard layout is above.

If you would like to shift the entire keyboard layout, press space, followed
by the origin of the shift, followed by the final position. The note that was
previously at the origin is now at the final position.
