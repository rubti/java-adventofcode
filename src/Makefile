FILES := $(shell find . -name "*.java")
BINARIES := $(shell find . -name "*.class")

all: $(FILES)
	@javac $(FILES)
	@java Main

clean:
	rm -rf $(BINARIES)