
dirpath=./
toolkits=$(dirpath)/../../streamsx.inet:$(dirpath)/../../streamsx.json
outputdir=$(dirpath)/output
sc=$(STREAMS_INSTALL)/bin/sc
smt=$(STREAMS_INSTALL)/bin/spl-make-toolkit

mains=TwitterSampleReaderMain

all: $(mains) toolkit

%Main:
	$(sc) -t $(toolkits) --output-dir $(outputdir)/$@/Standalone -T -M com.ibm.streamsx.social.twitter::$@
	$(sc) -t $(toolkits) --output-dir $(outputdir)/$@/Distributed -M com.ibm.streamsx.social.twitter::$@
	
toolkit:
	$(smt) -i $(dirpath)
	
clean:
	rm -rf $(outputdir)
	$(smt) -c -i $(dirpath)
	
